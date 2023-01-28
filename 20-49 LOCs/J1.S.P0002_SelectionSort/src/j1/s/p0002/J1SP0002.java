/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Lenovo
 */
public class J1SP0002 {

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
                System.out.println("Error: You have to type a number, not a string!");
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
    private static void selectionSort(int[] arr){
        int temp;
        int min_i = 0;
        for(int i=0;i<arr.length-1;i++){  //run from 1st element
            min_i = i;
            for(int j=i+1;j<arr.length;j++){ //Select from i to end
                if(arr[min_i]>arr[j]){    //If after < before
                    min_i = j;  //change the minimum index value 
                }    
            }
            temp = arr[min_i];
            arr[min_i] = arr[i];    //swap min value
            arr[i] = temp;
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
    //main
    public static void main(String[] args) {
        //Step 1: Enter positive decimal number
        int sizeOfArray = input();
        //Step 2: Generate random integer
        int[] arr = generateRandInt(sizeOfArray);
        //Step 3: Display unsorted
        displayUnsorted(arr);
        //Step 4: Sort
        selectionSort(arr);
        //Step 5: Display sorted
        displaySorted(arr);
    }
    
}
