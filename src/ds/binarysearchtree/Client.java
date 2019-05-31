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
public class Client {
    
    public static void main(String[] args) {
        
        BST tree = new BST();
    
        tree.insert(10, "Ten");
        tree.insert(20, "twenty");
        tree.insert(15, "fifteen");
        
//        System.out.println(tree.findMax().key);
//        System.out.println(tree.findMin().key);
//        
//        System.out.println("Delete: " + tree.remove(10));
//        System.out.println(tree.findMin().key );
        
        System.out.println("\n----------- Homework ------------\n");
        
        BST newTree = new BST();
        int[] keyArr = new int[] { 10, 4, 20, 2, 5, 18, 22, 8, 17, 19, 21, 24, 9, 33 };
        String[] valueArr = new String[] { "10", "4", "20", "2", "5", "18", "22", "8", "17", "19", "21", "24", "9", "33" };
        
        for( int i = 0; i < keyArr.length; i++){
            newTree.insert(keyArr[i], valueArr[i]);
        }
        
//        System.out.println("Height: " + newTree.getHeight(newTree.getRoot()));
//        newTree.levelTraversal(newTree.getRoot());
        newTree.printTree(newTree.getRoot());
        newTree.displayTree();
       
 
   } 
}
