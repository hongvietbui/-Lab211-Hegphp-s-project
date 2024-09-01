/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BubbleSort;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class BubbleSort {

    static void displayAskUserNumber() {
        //Ask user enter a number
        System.out.println("Enter number of array:");
    }

    static int checkPositiveDecNumber() {
        Scanner sc = new Scanner(System.in);
        int input;
        String inputString;
        //Loop until user type valid number
        while (true) {
            try {
                //check if user typed nothing
                inputString = sc.nextLine();
                if (inputString.equals("")) {
                    throw new NullPointerException();
                }
                input = Integer.parseInt(inputString);
                //check if input negative or not
                if (input <= 0) {
                    throw new NegativeArraySizeException();
                }
                return input;
            } catch (NullPointerException NullValue) {
                System.out.println("Error: Input mustn't be nothing. Please enter a number!");
                displayAskUserNumber();
            } catch (NumberFormatException FormatError) {
                System.out.println("Error: The input must be integer number. Please enter again!");
                displayAskUserNumber();
            } catch (NegativeArraySizeException NegativeError) {
                System.out.println("Error: Input musn't be negative or 0. Please enter again!");
                displayAskUserNumber();
            }
        }
    }

    static int[] generateArray(int input) {
        int[] arr = new int[input];
        Random rd = new Random();
        //Generate random each elements of array
        for (int i = 0; i < input; i++) {
            arr[i] = rd.nextInt(input);
        }
        return arr;
    }

    static void displayUnsortedArray(int[] arr) {
        System.out.print("Unsorted array: ");
        System.out.print("[");
        //Display from 1 to n-1 elements of array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    static int[] bubbleSort(int[] arr, boolean flag) {
        int temp;
        /*Loop used to access every elements of array from begin to end
        After each iterator, one elements is sorted*/
        for (int i = 0; i < arr.length; i++) {
            /*Access every elements from begin to the one before the last of the unsorted part of the array*/
            for (int j = 0; j < arr.length - i - 1; j++) {
                //Create new line to seperate between each iterator of i for better readability
                if(j==0&&flag == true)
                    System.out.println("");
                //Compare 2 adjacent numbers
                if (arr[j] > arr[j + 1]) {
                    //Display the current state of the array and the swap processing
                    if (flag == true) {
                        System.out.print("                ");
                        displayArray(arr);
                        System.out.print("\t"+arr[j] + " > " + arr[j+1] + ", swap\n");
                    }
                    //Swap 2 adjacent number if the former larger
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } 
                //Display the current state of the array and show the message that no swap occured.
                else if (flag == true) {
                    System.out.print("                ");
                    displayArray(arr);
                    System.out.print("\t"+arr[j] + " < " + arr[j + 1] + ", ok\n");
                }
            }
            //Create new line to seperate between showing sorted array and the sorting process for better readability
            if (flag == true && i == arr.length - 1) {
                System.out.println("");
            }
        }
        return arr;
    }

    static void displaySortedArray(int[] arr) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        //Display from 1 to n-1 elements of array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }
    
    static void displayArray(int[] arr) {
        System.out.print("[");
        //Display from 1 to n-1 elements of array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }

    public static void main(String[] args) {
//        //Step 1: Display message to notify user enter a number
//        displayAskUserNumber();
//        //Step 2: User input a positive decimal number
//        int arrSize = checkPositiveDecNumber();
//        //Step 3: Create array by generating random integer in number range
//        int[] arr = generateArray(arrSize);
//        boolean test = false;
        //----Test case-----
        int[] arr = new int[] {5,1,12,-5,16};
        boolean test = true;
        //Step 4: Display unsorted array
        displayUnsortedArray(arr);
        //Step 5: Sort by Bubble Sort
        bubbleSort(arr, test);
        //Step 6: Display sorted array
        displaySortedArray(arr);
    }
}
