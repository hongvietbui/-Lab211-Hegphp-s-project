/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
class getData {

    static int[][] getMatrix2(int[][] matrix1,int choice) {
        int row,col;
        if(choice == 1||choice ==2){
            //Loop until user typed valid row number
            while(true){
                row = getInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);
                //Check if the row of the matrix 2 is equal to the row of matrix 1 or not
                if(row==matrix1.length){
                   break; 
                }else{
                    System.out.println("Error: the row of matrix 2 must be equal to the row of matrix 1!");
                }
            }
            //Loop until user typed valid column number
            while(true){
                col = getInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);
                //Check if the row of the matrix 2 is equal to the row of matrix 1 or not
                if(col==matrix1[0].length){
                   break; 
                }else{
                    System.out.println("Error: the column of matrix 2 must be equal to the column of matrix 1!");
                }
            }
            int[][] matrix2 = new int[row][col];
            //Access every elements of the array
            for(int i=0;i<row;i++){
                //Access every element of the column each row
                for(int j=0;j<col;j++){
                    matrix2[i][j] = getMatrixValue("Enter Matrix2["+(i+1)+"]["+(j+1)+"]:",0,Integer.MAX_VALUE);
                }
            }
            return matrix2;
        }else{
            //Loop until user typed valid row number
            while(true){
                row = getInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);
                //Check if the row of the matrix 2 is equal to the row of matrix 1 or not
                if(row==matrix1[0].length){
                   break; 
                }else{
                    System.out.println("Error: the row of matrix 2 must be equal to the column of matrix 1!");
                }
            }
            col = getInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);
            int[][] matrix2 = new int[row][col];
            //Access every elements of the array
            for(int i=0;i<row;i++){
                //Access every element of the column each row
                for(int j=0;j<col;j++){
                    matrix2[i][j] = getMatrixValue("Enter Matrix2["+(i+1)+"]["+(j+1)+"]:",0,Integer.MAX_VALUE);
                }
            }
            return matrix2;
        }
    }

    static int[][] getMatrix1() {
        int row = getInt("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
        int col = getInt("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
        int[][] matrix = new int[row][col];
        //Access every elements of the array
        for(int i=0;i<row;i++){
            //Access every element of each row
            for(int j=0;j<col;j++){
                matrix[i][j] = getMatrixValue("Enter Matrix1["+(i+1)+"]["+(j+1)+"]:",0,Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    static int getInt(String msg,int min, int max){
        Scanner sc = new Scanner(System.in);
        int output;
        String stringInput;
        while(true){
            try{
                System.out.print(msg);
                stringInput = sc.nextLine();
                if(stringInput.equals(""))   //If user typed nothing
                    throw new Exception("You must input an number!");
                else{
                    output = Integer.parseInt(stringInput);
                    if(output<min||output>max)  //If user not typed correct number (from min to max)
                        throw new Exception("Error: the number you typed must be in range of "+min+" to "+max+"!");
                    return output;
                }
            }catch(NumberFormatException FormatError){  //Format Error
                System.out.println("Error: you must typed an integer number!");
            }catch(Exception ex){   //Other Exception
                System.out.println(ex.getMessage());
            }
        }
    }
    
    static int getMatrixValue(String msg,int min, int max){
        Scanner sc = new Scanner(System.in);
        int output;
        String stringInput;
        while(true){
            try{
                System.out.print(msg);
                stringInput = sc.nextLine();
                if(stringInput.equals(""))   //If user typed nothing
                    throw new Exception("Value of matrix is digit!");
                else{
                    output = Integer.parseInt(stringInput);
                    if(output<min||output>max)  //If user not typed correct number (from min to max)
                        throw new Exception("The number is too large or too small!");
                    return output;
                }
            }catch(NumberFormatException FormatError){  //Format Error
                System.out.println("Value of matrix is digit!");
            }catch(Exception ex){   //Other Exception
                System.out.println(ex.getMessage());
            }
        }
    }
}
