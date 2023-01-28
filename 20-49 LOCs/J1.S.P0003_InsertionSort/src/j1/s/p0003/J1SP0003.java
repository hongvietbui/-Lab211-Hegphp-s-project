/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0003;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class J1SP0003 {
    /**
     * @param args the command line arguments
     */
    // Input size of Array
    private static int input(){
        System.out.println("Enter number of Array:");
        Scanner sc = new Scanner(System.in);
        int sizeOfArray;
        while(true){
            try{
                sizeOfArray = Integer.parseInt(sc.nextLine());
                if(sizeOfArray<=0) throw new Exception("Error: You have type a positive number!"); // If user typing negative number
                return sizeOfArray;
            }catch(NumberFormatException stringError){  //If user trying to type String
                System.out.println("Error: You have to type an integer number!");
            }catch(Exception ex){   //Another exception
                System.out.println(ex.getMessage());
            }
        }
    }
    //Generate Random Integer Array
    private static int[] generateRandInt(int sizeOfArray){
        int[] arr = new int[sizeOfArray];
        Random rd = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i] = rd.nextInt(sizeOfArray);
        }
        return arr;
    }
    //display Unsorted Array
    private static void displayUnsorted(int[] arr){
        System.out.print("Unsorted array: ");
        for(int i=0;i<arr.length;i++){  //Run from 1st element
            if(i==0)    //If arr[i] is the 1st element
                System.out.print("["+arr[i]+", ");
            else if(i==arr.length-1)    //If the last
                System.out.print(arr[i]+"]");
            else{   //If not
                System.out.print(arr[i]+", ");
            }
        }
    }
    //selection Sort:
    private static void insertionSort(int[] arr){
    //Run from 2nd element to n-1
    for(int i=1;i<arr.length;i++){       
        int temp = arr[i];
        int j = i-1;
        while(j >= 0 && arr[j] > temp){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
        }
    }
    //DisplaySorted
    private static void displaySorted(int[] arr){
        System.out.print("\nSorted array: ");
        for(int i=0;i<arr.length;i++){  //Run from 1st element
            if(i==0)    //If arr[i] is the 1st element
                System.out.print("["+arr[i]+", ");
            else if(i==arr.length-1)    //If the last
                System.out.print(arr[i]+"]");
            else{   //If not
                System.out.print(arr[i]+", ");
            }
        }
    }
    public static void main(String[] args) {
        //Step 1: Input size of Array
        int sizeOfArray = input();
        //Step 2: generate random integer
        int[] arr = generateRandInt(sizeOfArray);
        //Step 3: Display unsorted array
        displayUnsorted(arr);
        //Step 4: Insertion sort
        insertionSort(arr);
        //Step 5: Display sorted array
        displaySorted(arr);
    }
    
}
