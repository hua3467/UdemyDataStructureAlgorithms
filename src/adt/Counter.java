/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author aaronyang
 */
public class Counter {
    
    private String name = null; 
    private int value = 0;
    
    Counter(String str){
        name = str;
    }
    
    public void increment(){
        value++;
    }
    
    public int getCurrentValue(){
        return value;
    }
    
    public String toString(){
        return name + ": " + value;
    }
}
