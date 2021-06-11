package com.apm.coding_problems.positions_attacked_by_rook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
to be added ...
 */
public class PositionsAttackedByRook {

  public static void main(String[] args) {
    int[][] chessBoard = new int[8][8];

    // One represents rook position
    chessBoard[0][1] = 1;
    chessBoard[3][5] = 1;
    chessBoard[4][3] = 1;
    chessBoard[6][0] = 1;
    chessBoard[6][5] = 1;

    System.out.println("BEFORE");
    printBoard(chessBoard);

    findAllPositionsAttackedByRooks_Approach1(chessBoard);
    System.out.println("AFTER");
    printBoard(chessBoard);
  }

  private static void findAllPositionsAttackedByRooks_Approach1(int[][] chessBoard) {

    class Cell {
      public int row;
      public int col;

      public Cell(int row, int col) {
        this.row = row;
        this.col = col;
      }
    };

    Set<Cell> cellsWithRook = new HashSet<>();

    for (int i=0; i<chessBoard.length; i++) {
      for (int j=0; j<chessBoard[0].length; j++) {
        if (chessBoard[i][j] == 1) {
          cellsWithRook.add(new Cell(i, j));
        }
      }
    }

    for (Cell rookCell : cellsWithRook) {
      markRookAttacked(chessBoard, rookCell.row, rookCell.col);
    }
  }

  private static void markRookAttacked(int[][] chessBoard, int rowAttacked, int colAttacked) {
    for (int col=0; col<chessBoard[0].length; col++) {
      chessBoard[rowAttacked][col] = 1;
    }
    for (int row=0; row<chessBoard.length; row++) {
      chessBoard[row][colAttacked] = 1;
    }

  }

  private static void printBoard(int[][] chessBoard) {
    Arrays.stream(chessBoard).forEach(row -> {
      System.out.print("[ ");
      Arrays.stream(row).forEach(val -> System.out.print(val + " "));
      System.out.println(" ]");
    });
  }
}
