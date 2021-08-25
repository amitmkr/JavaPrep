package com.apm.coding_problems.rotten_oranges;

import com.apm.utils.PrintHelper;

import java.net.SocketOption;

import static com.apm.utils.PrintHelper.*;

public class RottenOrangesTry2 {

  public static void main(String[] args) {
    int[][] grid = {
      {2,1,1,1,2,1,2,0,2},
      {1,2,1,1,2,1,1,2,2},
      {2,2,1,2,2,1,1,2,1},
      {1,0,2,0,1,2,2,1,0},
      {2,0,0,2,2,2,2,0,2},
      {2,1,1,1,2,0,2,1,2},
      {2,2,1,1,0,0,1,2,2},
      {0,2,0,2,2,2,2,2,1},
      {2,0,2,0,1,2,2,2,2},
      {1,1,1,2,0,1,2,2,2}
    };

    int num = orangesRotting(grid);

    System.out.println(num);
  }

  private static int orangesRotting(int[][] grid) {
    final int EMPTY=0, FRESH=1, ROTTEN=2;

    final int ROWS=grid.length, COLS=grid[0].length;

    int timeUnit = 0;

    boolean orangesRottenInCurrentTimeUnit = false;

    int currentRottenIndicator = ROTTEN;
    int nextRottenIndicator = currentRottenIndicator + 1;

    System.out.println("INITIAL");
    Print2dArray(grid);

    do {
      timeUnit++;
      orangesRottenInCurrentTimeUnit = false;

      for (int i=0; i<ROWS; i++) {
        for (int j=0; j<COLS; j++) {
          if (grid[i][j] > 1 && grid[i][j] <= currentRottenIndicator) {
            if (i>0 && grid[i-1][j] != EMPTY && grid[i-1][j] == FRESH) {
              grid[i-1][j] = nextRottenIndicator;
              orangesRottenInCurrentTimeUnit = true;
            }
            if (i<ROWS-1 && grid[i+1][j] != EMPTY && grid[i+1][j] == FRESH) {
              grid[i+1][j] = nextRottenIndicator;
              orangesRottenInCurrentTimeUnit = true;
            }
            if (j>0 && grid[i][j-1] != EMPTY && grid[i][j-1] == FRESH) {
              grid[i][j-1] = nextRottenIndicator;
              orangesRottenInCurrentTimeUnit = true;
            }
            if (j<COLS-1 && grid[i][j+1] != EMPTY && grid[i][j+1] == FRESH) {
              grid[i][j+1] = nextRottenIndicator;
              orangesRottenInCurrentTimeUnit = true;
            }
          }
        }
      }

      currentRottenIndicator = nextRottenIndicator;
      nextRottenIndicator = currentRottenIndicator + 1;

      System.out.println("Time=" + timeUnit);
      Print2dArray(grid);
    }
    while (orangesRottenInCurrentTimeUnit);

    return timeUnit-1;
  }
}
