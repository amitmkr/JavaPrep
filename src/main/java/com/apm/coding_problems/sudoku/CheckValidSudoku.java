package com.apm.coding_problems.sudoku;

import java.util.Arrays;

public class CheckValidSudoku {

  final static int EXPECTED_ANSWER = 123456789;

  public static void main(String[] args) {
    int[][] sudoku = {
      { 7, 9, 3, 8, 5, 2, 4, 6, 1 },
      { 6, 2, 8, 9, 1, 4, 5, 3, 7 },
      { 5, 1, 4, 3, 7, 6, 9, 2, 8 },
      { 3, 4, 6, 2, 8, 5, 7, 1, 9 },
      { 2, 5, 1, 4, 9, 7, 6, 8, 3 },
      { 8, 7, 9, 6, 3, 1, 2, 4, 5 },
      { 4, 3, 7, 1, 2, 9, 8, 5, 6 },
      { 9, 8, 2, 5, 6, 3, 1, 7, 4 },
      { 1, 6, 5, 7, 4, 8, 3, 9, 2 }
    };

    boolean isValidSudoku = check_valid_sudoku(sudoku);

    System.out.println(isValidSudoku ? "Sudoku VALID" : "Sudoku INVALID");
  }

  private static boolean check_valid_sudoku(int[][] sudoku) {
    int[] rowTotals = new int[9];
    int[] colTotals = new int[9];
    int[] boxTotals = new int[9];

    for (int i=0; i<9; i++) {
      for (int j=0; j<9; j++) {
        rowTotals[i] += getNumber(sudoku[i][j]);
        colTotals[j] += getNumber(sudoku[i][j]);
        boxTotals[3*(i/3)+(j/3)] += getNumber(sudoku[i][j]);
      }
    }

    System.out.println("ROW=" + Arrays.toString(rowTotals));
    System.out.println("COL=" + Arrays.toString(colTotals));
    System.out.println("BOX=" + Arrays.toString(boxTotals));

    return
      Arrays.stream(rowTotals).allMatch(i -> i == EXPECTED_ANSWER) &&
        Arrays.stream(colTotals).allMatch(i -> i == EXPECTED_ANSWER) &&
        Arrays.stream(boxTotals).allMatch(i -> i == EXPECTED_ANSWER);
  }

  private static int getNumber(int i) {
    switch (i) {
      case 1: return (int)(1 * Math.pow(10, 8));
      case 2: return (int)(2 * Math.pow(10, 7));
      case 3: return (int)(3 * Math.pow(10, 6));
      case 4: return (int)(4 * Math.pow(10, 5));
      case 5: return (int)(5 * Math.pow(10, 4));
      case 6: return (int)(6 * Math.pow(10, 3));
      case 7: return (int)(7 * Math.pow(10, 2));
      case 8: return (int)(8 * Math.pow(10, 1));
      case 9: return (int)(9 * Math.pow(10, 0));
      default: throw new RuntimeException("Unexpected number " + i);
    }
  }
}
