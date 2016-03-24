/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scenariomodeling.model;

import java.util.Map;

/**
 *
 * @author root
 */
public class Resource {
    int id;
    boolean isNew;

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    String label;
    Map<Integer,State> states;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<Integer, State> getStates() {
        return states;
    }

    public void setStates(Map<Integer, State> states) {
        this.states = states;
    }
}
