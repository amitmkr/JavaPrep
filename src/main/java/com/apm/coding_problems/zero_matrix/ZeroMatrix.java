package com.apm.coding_problems.zero_matrix;

/*
GayleLaakmann-1.8

Write an algorithm such that if an element in an MxN matrix is Zero, its entire row and column are set to Zero.
 */


import java.util.Arrays;

public class ZeroMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
      { 00, 12, 00, 14, 15, 16, 17 },
      { 21, 22, 23, 24, 25, 26, 27 },
      { 31, 32, 33, 34, 35, 36, 37 },
      { 41, 42, 43, 44, 00, 46, 47 },
      { 51, 52, 00, 54, 55, 56, 00 }
    };

    System.out.println("ORIGINAL");
    Arrays.stream(matrix).forEach(row -> { System.out.println(Arrays.toString(row)); });

    zeroMatrix(matrix);

    System.out.println("ZERO'ED");
    Arrays.stream(matrix).forEach(row -> { System.out.println(Arrays.toString(row)); });
  }

  private static void zeroMatrix(int[][] matrix) {
    for (int row=1; row<matrix.length; row++) {
      for (int col=1; col<matrix[0].length; col++) {
        if (matrix[row][col] == 0) {
          matrix[0][col] = 0;
          matrix[row][0] = 0;
        }
      }
    }

    for (int row=1; row<matrix.length; row++) {
      if (matrix[row][0] == 0) {
        for (int col=0; col<matrix[0].length; col++) {
          matrix[row][col] = 0;
        }
      }
    }

    for (int col=1; col<matrix[0].length; col++) {
      if (matrix[0][col] == 0) {
        for (int row=0; row<matrix.length; row++) {
          matrix[row][col] = 0;
        }
      }
    }

    if (matrix[0][0] == 0) {
      for (int col=0; col<matrix[0].length; col++) {
        matrix[0][col] = 0;
      }
      for (int row=0; row< matrix.length; row++) {
        matrix[row][0] = 0;
      }
    }
  }
}
