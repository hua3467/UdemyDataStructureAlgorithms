package ds.queue;

public class Queue {
    
    private int maxSize; // maintains the set number of slots
    private long[] queArray; // slots to main the data;
    private int front;  // the index position for the elemenet in the front;
    private int rear;
    private int nItems;
    
    public Queue(int size ){
        this.maxSize = size;
        this.queArray = new long[size];
        front = 0;  // index position of the first slot of the array
        rear = -1;  // there is no item in the array yet to be considered as the last item.
        nItems = 0;
    }
    
    public void insert(long j){
        
        if(rear == maxSize - 1){
            rear = -1;
        }
        
        rear++;
        queArray[rear] = j;
        nItems ++;
    }
    
    public long remove(){   //remove item from the front of the queue.
        long temp = queArray[front];
        front++;
        if(front == maxSize ){
            front = 0;  // we can set front back to the 0th index so that we can utilize the entire
        }
        nItems--;
        return temp;
    }
    
    public long peekFront(){
        return queArray[front];
    }
    
    public boolean isEmpty(){
        return nItems == 0;
    }
    
    public boolean isFull(){
        return nItems == maxSize;
    }
    
    public void view(){
        System.out.print("[ ");
        for(int i = 0; i < queArray.length; i++ ){
            System.out.print(queArray[i] + " ");
        }
        System.out.print("]");
    }
    
}
