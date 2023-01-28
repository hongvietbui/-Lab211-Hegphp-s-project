/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0010;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Lenovo
 */
public class J1SP0010 {
    /**
     * @param args the command line arguments
     */
    //Input
    private static int input(String msg){
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        int num;
        while(true){    //typing until valid
            try{
            num = Integer.parseInt(sc.nextLine());
            //If number <0
            if(num<0) throw new Exception("Error: The number you typed must be non-negative!");
            return num;
            }catch(NumberFormatException FormatError){  //User typed string or real number
                System.out.println("Error: You have to type an integer number!");
            }catch(Exception ex){   //Another error
                System.out.println(ex.getMessage());
            }
        }
    }
    //Generate random integer
    private static int[] generateRandInt(int sizeOfArray){
        Random rd = new Random();
        int[] arr = new int[sizeOfArray];
        for(int i=0;i<arr.length;i++){
            arr[i]=rd.nextInt(sizeOfArray);
        }
        return arr;
    }
    //Display the Array
    private static void display(int[] arr){
        System.out.print("The array: ");
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
    //Display index of the 1st searched number
    private static void displayIdxOfSearchNum(int[] arr,int searchValue){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == searchValue){
                System.out.println("\nFound "+arr[i]+" at index: "+i);
                return;
            }
        }
        System.out.println("\nNot Found!");
    }
    //Main
    public static void main(String[] args) {
        //Step 1: Enter number of array
        int sizeOfArray = input("Enter number of array:");
        int searchValue = input("Enter search value:");
        //Step 2: Generate random integer
        int[] arr = generateRandInt(sizeOfArray);
        //Step 3: Display the array
        display(arr);
        //Step 4:Display the index of search number in array
        displayIdxOfSearchNum(arr,searchValue);
    }
    
}
