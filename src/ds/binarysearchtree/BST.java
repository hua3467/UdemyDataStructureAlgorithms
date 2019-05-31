/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.binarysearchtree;

import java.util.Stack;


/**
 *
 * @author aaronyang
 */
public class BST {
    
    private Node root;
    
    public Node getRoot(){
        return root;
    }
    
    public void insert(int key, String value){
        
        Node newNode = new Node(key, value);
        
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;        // the parent of current node
            
            while(true){ 
                parent = current;
                if(key < current.key){
                    current = current.leftChild;
                    if(current == null){        //its parent is the leaf node
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public Node findMin(){
        Node current = root;
        Node last = null;
        
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }
    
    public Node findMax(){
        Node current = root;
        Node last = null;
        
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        
        return last;
    }
    
    public int getHeight(Node treeNode){
        
        if(treeNode == null)
            return 0;
        else {
            int heightLeft = getHeight(treeNode.leftChild);
            int heightRight = getHeight(treeNode.rightChild);
            return (heightLeft > heightRight)? heightLeft + 1 : heightRight + 1;
        }
        
    }
    
    
    
    public boolean remove(int key){
        
        Node currentNode = root;
        Node parentNode = root;
        
        boolean isLeftChild = false;
        
        // Searching to find the node with the key to delete
        while(currentNode.key != key){
            parentNode = currentNode;
            if(key < currentNode.key){
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
            if(currentNode == null)
                return false;
        }   
        
        // found the node 
        Node nodeToDelete = currentNode;
        
        // 1. if node is a leaf
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if(nodeToDelete == root){
                root = null;
            } else if(isLeftChild){
                parentNode.leftChild = null;
        }else{
                parentNode.rightChild = null;
            }
        } 
        
        // 2. if the node has one child on the left 
        else if(nodeToDelete.rightChild == null){     
            if(nodeToDelete == root)
                root = nodeToDelete.leftChild;
            else if (isLeftChild)
                parentNode.leftChild = nodeToDelete.leftChild;
            else
                parentNode.rightChild = nodeToDelete.leftChild;
        }
        // 3. if the node has one child one the right
        else if(nodeToDelete.leftChild == null){
            if(nodeToDelete == root)
                root = nodeToDelete.rightChild;
            else if(isLeftChild)
                parentNode.leftChild = nodeToDelete.rightChild;
            else
                parentNode.rightChild = nodeToDelete.rightChild;
        }
        
        // 3. if the node has two children
        else{
            
            Node successor = getSuccessor(nodeToDelete);
            
            // connect parent of nodeToDelete to successor instead
            if(nodeToDelete == root)
                root = successor;
            else if(isLeftChild)
                parentNode.leftChild = successor;
            else
                parentNode.rightChild = successor;
            
            successor.leftChild = nodeToDelete.leftChild;
        }
        
        return true;
    }
    
    private Node getSuccessor(Node nodeToDelete){
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;
        
        Node current = nodeToDelete.rightChild; // go to the right child
        
        while(current != null){     // start going left down the tree untill node has no left child
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        // if successor not a right child
        if(successor != nodeToDelete.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }
    
    public void levelTraversal(Node node){
        if(node == null)
            return;
        Queue q = new LinkedQueue();
        q.enqueue(node);
        
        while(!q.isEmpty()){
            node = (Node)q.dequeue();
            System.out.println( node.key );
            if(node.leftChild != null)
                q.enqueue(node.leftChild);
            if(node.rightChild != null)
                q.enqueue(node.rightChild);
        }
    }
    
    public void printTree(Node node){
        
        Node placeHolder = new Node(0, "--");
        Queue q = new LinkedQueue();
        Queue q2 = new LinkedQueue();
        
        System.out.println("================================================================");
        
        if(node == null)
            return;
        
        q.enqueue(node);
        
        for(int i = 0; i < 62; i++ ){
            node = (Node)q.dequeue();
            q2.enqueue(node);
            
            if(node.leftChild == null)
                q.enqueue(placeHolder);
            else
                q.enqueue(node.leftChild);
            
            if(node.rightChild == null)
                q.enqueue(placeHolder);
            else
                q.enqueue(node.rightChild);
        }
        
        String str = "";
        for(int i = 0; i < q2.size(); i++){
            
            str += ((Node)q2.dequeue()).value + " ";
            
            if(i == 0 || i == 2 || i == 6 || i == 14)   // this should be dynamically set according to the height of the tree.
                str += "\n";
        }
        System.out.println(str);
        
        System.out.println("================================================================");

    } 
    
    // Intructor solution
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }
                
            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.key); 
                    localStack.push(temp.leftChild); 
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
 
 }
    
}
