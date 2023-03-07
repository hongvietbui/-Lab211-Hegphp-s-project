/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

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
        test = true;
        //Generate array has 45 numbers using Fibonacci
        int arr[] = fibonacciGenerate(45);
        //Display all 45 number to screen
        displayArray(arr,test);
    }
    //Generate fibonacci Array
    private static int[] fibonacciGenerate(int number) {
        int[] arr = new int[number];
        //Access every element of the array
        for(int i=0;i<45;i++){
            arr[i] = fibonacciRecursion(i);
        }
        return arr;
    }
    //Fibonacci algorithm using Recursion
    private static int fibonacciRecursion(int num) {
        //Check if fibonacci is the 1st element or not
        if(num==0)
            return 0;
        //Check if fibonacci is the 2nd element or not
        if(num==1)
            return 1;
        return fibonacciRecursion(num-1)+fibonacciRecursion(num-2);
    }
    //Display array
    private static void displayArray(int[] arr,boolean test) {
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
