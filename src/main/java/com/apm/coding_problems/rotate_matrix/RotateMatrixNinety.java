package com.apm.coding_problems.rotate_matrix;

/*
GayleLaakmann-1.7

Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the
image by 90 degrees.

Can this be done in-place ?
 */

import java.util.Arrays;

public class RotateMatrixNinety {

  public static void main(String[] args) {

    int[][] oddMatrix = {
      { 10, 11, 12, 13, 14 },
      { 20, 21, 22, 23, 24 },
      { 30, 31, 32, 33, 34 },
      { 40, 41, 42, 43, 44 },
      { 50, 51, 52, 53, 54 }
    };

    int [][] evenMatrix = {
      { 10, 11, 12, 13 },
      { 20, 21, 22, 23 },
      { 30, 31, 32, 33 },
      { 40, 41, 42, 43 }
    };

    System.out.println("ODD");
    rotate_matrix_in_place(oddMatrix);
    Arrays.stream(oddMatrix).forEach(x -> { System.out.println(Arrays.toString(x)); });

    System.out.println("EVEN");
    rotate_matrix_in_place(evenMatrix);
    Arrays.stream(evenMatrix).forEach(x -> { System.out.println(Arrays.toString(x)); });
  }

  private static void rotate_matrix_in_place(int[][] matrix) {
    internal_rotate_matrix_in_place(matrix, matrix.length);
  }

  private static void internal_rotate_matrix_in_place(int[][] matrix, int subMatrixLength) {
    if (subMatrixLength == 0 || subMatrixLength == 1) {
      return;
    }

    int subMatrixStart = (matrix.length - subMatrixLength) / 2;
    int subMatrixEnd = matrix.length - subMatrixStart - 1;

    // Rotate
    for (int  firstRowColumn = subMatrixStart,
              lastColumnRow = subMatrixStart,
              lastRowColumn = subMatrixEnd,
              firstColumnRow = subMatrixEnd
              ;
              firstRowColumn <= subMatrixEnd - 1
              ;
                    firstRowColumn++,
                    lastColumnRow++,
                    lastRowColumn--,
                    firstColumnRow--
            ) {
      int temp = matrix[subMatrixStart][firstRowColumn];

      matrix[subMatrixStart][firstRowColumn] = matrix[lastColumnRow][subMatrixEnd];
      matrix[lastColumnRow][subMatrixEnd] = matrix[subMatrixEnd][lastRowColumn];
      matrix[subMatrixEnd][lastRowColumn] = matrix[firstColumnRow][subMatrixStart];
      matrix[firstColumnRow][subMatrixStart] = temp;
    }

    //Arrays.stream(matrix).forEach(x -> { System.out.println(Arrays.toString(x)); });
    internal_rotate_matrix_in_place(matrix, subMatrixLength - 2);
  }
}
