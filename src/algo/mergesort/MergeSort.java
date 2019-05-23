/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.mergesort;

/**
 *
 * @author aaronyang
 */
public class MergeSort {
    
    public static void sort(int inputArray[]){
        sort(inputArray, 0, inputArray.length-1);
    }
    
    public static void sort(int inputArray[], int start, int end){
        if(end <= start){
            return;     // we've done traversing the array
        }
        
        int mid = (start + end)/2;
        sort(inputArray, start, mid);
        sort(inputArray, mid+1, end);
        merge(inputArray, start, mid, end); // merge sorted results into the inputArray
    }
    
    public static void merge(int inputArray[], int start, int mid, int end){
        int tempArray[] = new int[end - start + 1];
        
        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;
        
        while(leftSlot <= mid && rightSlot <= end){
            
        }
    }
    
    
}
