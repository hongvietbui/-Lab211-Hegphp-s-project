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
class MatrixCalculator {

    int[][] getAdditionTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //access every element of both matrix
        for(int i=0;i<matrix1.length;i++){
            //Access every element of each row
            for(int j=0;j<matrix1[0].length;j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    int[][] getSubtractionTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //access every element of both matrix
        for(int i=0;i<matrix1.length;i++){
            //Access every element of each row
            for(int j=0;j<matrix1[0].length;j++){
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    int[][] getMultiplicationTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        //Access each matrix 2's column
        for(int i=0;i<matrix2[0].length;i++){
            //Access every element of each matrix 1's column and matrix2's row
            for(int j=0;j<matrix2.length;j++){
                //Access every element of each matrix1's row
                for(int k=0;k<matrix1.length;k++){
                    result[k][i] += matrix1[k][j] * matrix2[j][i];
                }
            }
        }
        return result;
    }
}
