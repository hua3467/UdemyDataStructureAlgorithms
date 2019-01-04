package algo.linearsearch;

public class App {
    public static void main( String[] args ){
        
    }
    
    public static int linearSearch( int [] a, int x ){
        int p = 0;
        int r = a.length;
        
        while( p <= r ){
            int q = ( p + r ) / 2;
            if( x < a[q] ) r = q - 1;
            else if( x > a[q] ) p = q + 1;
            else return q;
        }
    }
}

