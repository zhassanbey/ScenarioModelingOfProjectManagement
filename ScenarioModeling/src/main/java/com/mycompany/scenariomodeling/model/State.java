/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scenariomodeling.model;

/**
 *
 * @author root
 */
public class State {
    int id;
    String label;
    int tr;
    int cor;
    int lastTime;

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public int getMtbf() {
        return mtbf;
    }

    public void setMtbf(int mtbf) {
        this.mtbf = mtbf;
    }
    int mtbf;
    
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setLable (String label){
        this.label = label;
    }
    public String getLabel(){
        return label;
    }
    public void setTr(int tr){
        this.tr = tr;
    }
    public int getTr(){
        return tr;
    }
    public void setCor(int cor){
        this.cor = cor;
    }
    public int getCor(){
        return cor;
    }
    
}
