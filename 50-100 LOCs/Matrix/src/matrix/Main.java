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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        MatrixCalculator cal = new MatrixCalculator();
        int[][] matrix1;
        int[][] matrix2;
        int[][] result;
        int choice;
        while(true){
        //Display menu
            display.displayMenu();
        //User input the option
            choice = getData.getInt("Your choice: ",1,4);
        //Perform function based on selected function
            switch(choice){
            //Option 1: Addition matrixes
                case 1:
                    System.out.println("-------- Addittion --------");
                //User input 1st matrix
                    matrix1 = getData.getMatrix1();
                //User input 2nd matrix
                    matrix2 = getData.getMatrix2(matrix1, choice);
                //Addition 2 matrixes together
                    result = cal.getAdditionTwoMatrix(matrix1,matrix2);
                //Display result
                    display.displayResult(matrix1,matrix2,result,choice);
                    break;
            //Option 2: Subtraction matrixes
                case 2:
                System.out.println("----- Subtraction -----");
                //User input 1st matrix
                    matrix1 = getData.getMatrix1();
                //User input 2nd matrix
                    matrix2 = getData.getMatrix2(matrix1, choice);
                //Addition 2 matrixes together
                    result = cal.getSubtractionTwoMatrix(matrix1,matrix2);
                //Display result
                    display.displayResult(matrix1,matrix2,result,choice);
                    break;
            //Option 3: Multiplication matrix
                case 3:
                System.out.println("-------- Multiplication --------");
                //User input 1st matrix
                    matrix1 = getData.getMatrix1();
                //User input 2nd matrix
                    matrix2 = getData.getMatrix2(matrix1, choice);
                //Multiply 2 matrixes
                    result = cal.getMultiplicationTwoMatrix(matrix1,matrix2);
                //Display result
                    display.displayResult(matrix1,matrix2,result,choice);
                    break;
            //Option 4: Exit the program
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
