/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author Lenovo
 */
class Display {

    void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        char character;
        if(choice == 1)
            character = '+';
        else if(choice == 2)
            character = '-';
        else
            character = '*';
        System.out.println("-------- Result --------");
        //Access every elements of matrix1
        for(int i=0;i<matrix1.length;i++){
            //Access every elements of each row
            for(int j=0;j<matrix1[0].length;j++){
                System.out.print("["+matrix1[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println(character);
        //Access every elements of matrix2
        for(int i=0;i<matrix2.length;i++){
            //Access every elements of each row
            for(int j=0;j<matrix2[0].length;j++){
                System.out.print("["+matrix2[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println("=");
        //Access every elements of result matrix
        for(int i=0;i<result.length;i++){
            //Access every elements of each row
            for(int j=0;j<result[0].length;j++){
                System.out.print("["+result[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
}
