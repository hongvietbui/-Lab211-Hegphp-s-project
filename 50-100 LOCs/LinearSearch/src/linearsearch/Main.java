/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: User input a positve decimal number as the number of the array
        int size = inputPosDecNum("Enter number of array:\n");
        //Step 2: Generate random integer array in number range input
        int[] arr = generateRandomIntArrayInRange(size);
        //Step 3: User enter a positive decimal number in range of 1 to size
        int searchNum = inputPosDecNum("Enter search value:\n");
        //Step 4: Display the array
        displayArray(arr);
        //Step 5: Display the index of search number in array
        displayIndexOfSearchNum(arr, searchNum);
    }

    private static int inputPosDecNum(String msg) {
        String input;
        Scanner sc = new Scanner(System.in);
        int output;
        //Loop until user typed valid number
        while(true){
            try{
                System.out.print(msg);
                input = sc.nextLine();
                //Check if user typed nothing
                if(input.equals(""))
                    throw new NullPointerException();
                output = Integer.parseInt(input);
                //Check if user type non-positive number or not
                if(output<=0)
                    throw new Exception("Error: the number must be positive!");
                return output;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You must typed a number");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static int[] generateRandomIntArrayInRange(int size) {
        int[] arr = new int[size];
        Random rd = new Random();
        //Access every elements from 1st element to the last element
        for(int i=0;i<size;i++){
            arr[i]=rd.nextInt(size);
        }
        return arr;
    }

    private static void displayArray(int[] arr) {
        System.out.print("The array: ["+arr[0]);
        //Access elements from 2nd to end
        for(int i=1;i<arr.length;i++){
            System.out.print(", "+arr[i]);
        }
        System.out.println("]");
    }

    private static void displayIndexOfSearchNum(int[] arr, int searchNum) {
        //Access every elements from 1st to last
        for(int i=0;i<arr.length;i++){
            //Check if the number is equal to one element or not
            if(arr[i]==searchNum){
                System.out.println("Found "+arr[i]+" at index: "+i);
                return;
            }
        }
        System.out.println("Not found!");
    }
}
