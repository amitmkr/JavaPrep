package com.apm.coding_problems.advance_through_array;

/*
In a particular board game, a player has to try to advance through a sequence of
positions. Each position has a nonnegative integer associated with it, representing
the maximum you can advance from that position in one move. You begin at the first
position, and win by getting to the last position.

For example, let A = (3,3,1,0,2,0,1}
represent the board game, i.e., the ith entry in A is the maximum we can advance
from i. Then the game can be won by the following sequence of advances through
A: take 1 step from A[0] to A[1], then 3 steps from A[l] to A[4], then 2 steps from
A[4] to A[6], which is the last position. Note that A[0] = 3 > 1, A[l] = 3 > 3, and
A[4] = 2 > 2, so all moves are valid.

If A instead was (3,2,0,0,2,0,1), it would not
possible to advance past position 3, so the game cannot be won.

Write a program which takesan array of n integers, where A[i] denotes the maximum
you can advance from index i, and returns whether it is possible to advance to the
last index starting from the beginning of the array.
 */


public class AdvanceThroughArray {

  private static boolean internal_canWinBoard(int[] boardMoves, int startFrom) {
    //System.out.println("S="+startFrom);
    if (startFrom == boardMoves.length - 1)
      return true;
    else if (startFrom >= boardMoves.length)
      return false;
    else {
      for (int i=1; i<=boardMoves[startFrom]; i++) {
        if (internal_canWinBoard(boardMoves, startFrom+i)) {
          System.out.print(startFrom + ",");
          return true;
        }
      }
      return false;
    }
  }

  private static boolean canWinBoard_recursive(int[] boardMoves) {
    return internal_canWinBoard(boardMoves, 0);
  }

  private static boolean canWinBoard_iterative(int [] boardMoves) {
    int furthestReached = 0;
    for (int i=0; i<boardMoves.length; i++) {
      // This is the most important condition that enables iteration
      // If the position I am at now, is more than the furthest I could reach from the board,
      // then the board is un-winnable
      if (i > furthestReached)
        return false;
      else if (i + boardMoves[i] > furthestReached) {
        furthestReached = boardMoves[i] + i;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] boardMoves1 = new int[] { 3, 3, 1, 0, 2, 0, 1 };
    System.out.println("\nCan Win Board 1 - Recursive = " + canWinBoard_recursive(boardMoves1));
    System.out.println("\nCan Win Board 1 - Iterative = " + canWinBoard_iterative(boardMoves1));

    int[] boardMoves2 = new int[] { 3, 2, 0, 0, 2, 0, 1 };
    System.out.println("\nCan Win Board 2 - Recursive = " + canWinBoard_recursive(boardMoves2));
    System.out.println("\nCan Win Board 2 - Iterative = " + canWinBoard_iterative(boardMoves2));

    int[] boardMoves3 = new int[] { 2, 4, 1, 1, 0, 2, 3 };
    System.out.println("\nCan Win Board 3 - Recursive = " + canWinBoard_recursive(boardMoves3));
    System.out.println("\nCan Win Board 3 - Iterative = " + canWinBoard_iterative(boardMoves3));
  }
}
