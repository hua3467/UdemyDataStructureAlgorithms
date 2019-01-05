package algo.recursion;

public class App {
    public static void main( String [] args ){
        
        int [] arr = {1,2,3,4,7,9,12,18};
        System.out.println(recursiveBinarySearch(arr, 0, 7, 18));
    }
    
    public static void reduceByOne( int n ){
        if( n >= 0 ){   // base case
            reduceByOne( n - 1 );
        }
        
        System.out.println(n);
    }
    
    public static int recursiveLinarSearch( int[] a, int i, int x){
        
        if( i > a.length - 1 ) return -1; // if evaluates to true, x was not found in the array.
        else if( a[i] == x ) return i;
        else {
            System.out.println("index at: " + i );
            return recursiveLinarSearch( a, i + 1, x ); 
        }
    }
    
    public static int recursiveBinarySearch( int[]a, int p, int r, int x ){
        System.out.println("[" + p + "..." + r + "]");
        if( p > r )
            return -1;
        else{
            int q = (p+r)/2;
            if( a[q] == x )
                return q;
            else if(a[q]>x)
                return recursiveBinarySearch(a, p, q-1, x);
            else
                return recursiveBinarySearch(a, q+1, r, x);
        }
        
    }
}
