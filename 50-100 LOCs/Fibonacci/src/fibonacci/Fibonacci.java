/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean test = false;
//        test = true;
        //Generate array has 45 numbers using Fibonacci
        int[] arr = fibonacciArray(45);
        //Display all number of array to screen
        displayArray(arr,test);
    }
//Generate fibonacci Array
private static int[] fibonacciArray(int length) {
	//Create an array of given length
	int[] arr = new int[length];
	//Call the helper function with initial values
	fibonacciArrayHelper(arr, length, 0, 1);
	//Return the array
	return arr;
}

//Helper function that uses recursion
private static void fibonacciArrayHelper(int[] arr, int length, int i, int j) {
	//Base case: if length is 0 or negative, return
	if (length <= 0) {
		return;
	}
	//Check if i and j are valid indices
	if (i < arr.length && j < arr.length) {
		//Store the first Fibonacci number at index i
		arr[i] = i;
		//Store the second Fibonacci number at index j
		arr[j] = j;
		//Recursively call the helper function with updated values
		fibonacciArrayHelper(arr, length-2, j+1, j+2);
	}
} 
    //Display array
    private static void displayArray(int[] arr, boolean test) {
        System.out.println("The 45 sequence fibonacci:");
        //Access all elements of the array
        for(int i=0;i<arr.length;i++){
            //Check if element is the 1st or not
            if(i==0){
                if(test == true)
                    System.out.print((i+1)+"-");
                System.out.print(arr[0]);
            }
            else{
                System.out.print(", ");
                if(test == true)
                    System.out.print((i+1)+"-");
                System.out.print(arr[i]);
            }
        }
        System.out.println("");
    }
}
