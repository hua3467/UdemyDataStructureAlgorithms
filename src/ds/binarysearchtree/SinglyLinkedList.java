package ds.binarysearchtree;

/**
 * SinglyLinkedList Class
 * Code Fragments 3.14, 3.15
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author joseph.latimer
 */

public class SinglyLinkedList<E> {
    
   // -------------nested Node class--------------
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    } // --------------end of nested Node class----------
    
    // instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList(){}
    // access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    // update methods
    public void addFirst(E e){
        head = new Node<>(e, head);     //public Node(E e, Node<E> n){ element = e; next = n;}
        if(size == 0)
            tail = head;
        size++;
    }
    public void addLast(E e){            // add element e to the end of the list
        Node<E> newest = new Node<>(e, null);// node will eventually be the tail
        if(isEmpty())                   
            head = newest;              // special case: previously empty list
        else
            tail.setNext(newest);       // new node after existing tail
        tail = newest;                  // new node becomes the tail
        size++;
    }
    public E removeFirst(){             // removes and returns the first element
        if(isEmpty()) return null;      // nothing to remove
        E answer = head.getElement();
        head = head.getNext();          // will become null if list had only one node
        size--;
        if(size == 0)
            tail = null;                // special case as list is now empty
        return answer;
    }
    
}
