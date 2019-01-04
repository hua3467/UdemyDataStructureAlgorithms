package ds.doublylinkedlist;

public class Doublylinkedlist {
    private Node first;
    private Node last;
    
    public Doublylinkedlist(){
        this.first = null;
        this.last = null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        
        if(isEmpty()){
            last = newNode;
        } else {
            first.previous = newNode;
        }
        
        newNode.next = first;
        this.first = newNode;
    }
    
    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        
        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;    // assigning old last to newnode
            newNode.previous = last;    // the old last will be the newnodes previous
        }
        
        last = newNode; // the linkedList's last field should point to the new node
    }
    
    public Node deleteFirst(){
        
        Node temp = first;
        if(first.next == null){ // there is only one item in the list
            last = null;
        }else{
            first.next.previous = null; // the list's node will point to null
        }
        first = first.next; // we are assigning the reference of the node following the old first node the the first field in the inkedlist object.
        
        return temp;
    }
    
    public Node deleteLast(){
        Node temp = last;
        
        if(first.next == null){
            first = null;
        }else{
            last.previous.next = null;  
        }
        
        last = last.previous;
        
        return temp;
    }
    
    public boolean insertAfter( int key, int data ){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return false;
            }
        }
        
        Node newNode = new Node();
        newNode.data = data;
        
        if(current == last){
            current.next = null;
            last = newNode;
        } else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        
        newNode.previous = current;
        current.next = newNode;
        
        return true;
    }
    
    public Node deleteKey(int key){
        Node current = first;
        
        
        while(current.data != key){
            current = current.next;
            if(current == null ){
                return null; 
            }      
        }
        
        if(current == first){
            first = current.next;
        }else{
            
            current.previous.next = current.next;
        }
        
        if(current == last){
            last = current.previous;
        }else{
            current.next.previous = current.previous;
        }
        
        return current;
    }
    
    public void displayForward(){
        System.out.print("List(fitst --> last) ");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }
    
    public void displayBackward(){
        System.out.print("List(last --> first) ");
        Node current = last;
        while(current != null){
            current.displayNode();
            current = current.previous;
        }
        System.out.println();
    }
}