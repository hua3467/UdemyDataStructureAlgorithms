package ds.stack;

public class App {
    public static void main(String [] args ){
        Stack theStack = new Stack(3);
        
//        theStack.push(20);
//        theStack.push(40);
//        theStack.push(60);
//        theStack.push(80);
        
//        while(!theStack.isEmpty()){
//            long value = theStack.pop();
//            System.out.println(value);
//        }

        System.out.println(reverseString("Hello"));
    }
    
    public static String reverseString(String str){
        
        int len = str.length();
        
        Stack theStack = new Stack(len);
        
        for(int i = 0; i < len; i++ ){
            theStack.push(str.charAt(i));
        }
        
        str = "";
        
        for(int i = 0; i < len; i++ ){
            str+=theStack.pop();
        }
        
        return str;
    }
}
