/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scenariomodeling;

import com.mycompany.scenariomodeling.model.Node;
import com.mycompany.scenariomodeling.model.Resource;
import com.mycompany.scenariomodeling.model.State;
import com.mycompany.scenariomodeling.model.Tree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class ResourceStateTree {

    public static void main(String args[]) throws FileNotFoundException {
        //reading stuff...
        Scanner in = new Scanner(new File("input.txt"));
        int time = in.nextInt();
        int budget = in.nextInt();
        int n = in.nextInt();
        Resource[] resources = new Resource[n];
        int minResId = 0;
        int minTbf = 0;
        for (int i = 0; i < n; i++) {
            Resource res = new Resource();
            res.setIsNew(true);
            int st = in.nextInt();
            String label = in.next();
            res.setId(i);
            res.setLabel(label);
            Map<Integer, State> states = new HashMap<>();
            for (int j = 0; j < st; j++) {
                State state = new State();
                state.setLastTime(0);
                int mtbf = in.nextInt();
                int tr = in.nextInt();
                int cor = in.nextInt();
                String stLabel = in.next();
                state.setMtbf(mtbf);
                state.setCor(cor);
                state.setId(j);
                state.setLable(stLabel);
                state.setTr(tr);
                states.put(j, state);
            }
            res.setStates(states);
            resources[i] = res;
        }
        System.out.println("resources.size = " + resources.length);
        //processing..
        Tree tree = new Tree(time, budget);
        tree.setResources(resources);
        List<Node> nodes = new ArrayList<>();
        nodes.add(tree.getRoot());
        while (!nodes.isEmpty()) {
            List<Node> newnodes = new ArrayList<>();
            for (Node node : nodes) {
                for (int i = 0; i < resources.length; i++) {
                    for (Integer key : resources[i].getStates().keySet()) {
                        tree.add(node, i, key);
                    }
                }
                System.out.println("nodes.size = " + nodes.size());
                if (node.getChildren() != null && node.getTime() > 0 && node.getCost() > 0) {
                    for(Node child:node.getChildren()){
                        if(child.getTime()>0 && child.getCost()>0 && (child.getResId()!=node.getResId() || child.getStateId() != node.getStateId())){
                            newnodes.add(child);
                        }
                    }
                }
            }
            nodes = newnodes;
            System.out.println("size = " + nodes.size());
        }
        tree.print();
    }
}
