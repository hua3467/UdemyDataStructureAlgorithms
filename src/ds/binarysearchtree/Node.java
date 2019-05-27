/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.binarysearchtree;

/**
 *
 * @author aaronyang
 */
public class Node {
    
    int key;
    String value;
    Node leftChild, rightChild;
    
    public Node(int key, String value){
        super();
        this.key = key;
        this.value = value;
    }
}
