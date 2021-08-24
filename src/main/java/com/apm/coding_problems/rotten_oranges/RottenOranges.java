package com.apm.coding_problems.rotten_oranges;

/*
https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1/

Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges.
A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and
(2,1) in unit time.

Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.


Expected Time Compelxity: O(n*m)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n, m ≤ 500

 */

public class RottenOranges {

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
    int num = 0;
    boolean someRotten = false;

    final int EMPTY=0, FRESH=1, ROTTEN=2;
    final int ROWS=grid.length, COLS=grid[0].length;

    int currentRotten = ROTTEN + 1;
    do {
      someRotten = false;

      for (int i=0; i<ROWS; i++) {
        for (int j=0; j<COLS; j++) {
          if (grid[i][j] >= ROTTEN && grid[i][j] < currentRotten) {
            if (i>0 && grid[i-1][j] == FRESH) {
              grid[i-1][j] = currentRotten;
              someRotten = true;
            }
            if (j>0 && grid[i][j-1] == FRESH) {
              grid[i][j-1] = currentRotten;
              someRotten = true;
            }
            if (i<ROWS-1 && grid[i+1][j] == FRESH) {
              grid[i+1][j] = currentRotten;
              someRotten = true;
            }
            if (j<COLS-1 && grid[i][j+1] == FRESH) {
              grid[i][j+1] = currentRotten;
              someRotten = true;
            }
          }
        }
      }

      if (someRotten) {
        num++;
        currentRotten++;
      }
    }
    while (someRotten);

    return num>0 ? num : -1;
  }
}
