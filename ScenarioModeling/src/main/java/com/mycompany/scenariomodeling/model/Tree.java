/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scenariomodeling.model;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class Tree {

    public Resource[] resources;
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Tree(int deadline, int budget) {
        root = new Node();
        root.setCost(budget);
        root.setTime(deadline);
        root.setWorkTime(0);
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

    public void add(Node parent, int resId, int stateId) {
        Resource res = resources[resId];
        State state = res.getStates().get(stateId);
        
        if ((parent.getTime() <= 0 || parent.getCost() <= 0 || state.getMtbf()>root.getTime()) ) {
            System.out.println("Oh, overrun the tresholds");
        
        } else {
            Node node = new Node();
            node.setTime(parent.getTime() - state.getTr()-state.getMtbf());
            node.setCost(parent.getCost() - state.getCor());
            node.setResId(resId);
            node.setStateId(stateId);
            node.setWorkTime(state.getMtbf()+parent.getWorkTime());
            if (parent.getChildren() == null) {
                List<Node> children = new ArrayList<>();
                children.add(node);
                parent.setChildren(children);
            } else {
                parent.getChildren().add(node);
            }
            state.setLastTime(parent.getTime()-node.getTime());
        }
    }

    public void print() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("tree.txt"));
        Gson gson = new Gson();
        String json = gson.toJson(root);
        out.print(json);
        out.close();
    }
}
