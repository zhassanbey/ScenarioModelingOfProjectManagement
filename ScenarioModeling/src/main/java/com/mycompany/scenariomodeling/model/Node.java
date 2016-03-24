/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scenariomodeling.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author root
 */
public class Node {

    private int time;
    private int cost;
    private List<Node> children;
    private int resId;
    private int stateId;
    private Map<Integer, Integer> lstTime;
    private int workTime;

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
    public Map<Integer, Integer> getLstTime() {
        return lstTime;
    }

    public void setLstTime(Map<Integer, Integer> lstTime) {
        this.lstTime = lstTime;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

}
