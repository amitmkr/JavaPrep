package com.apm.coding_problems.delete_dups_sorted_array;

/*
This problem is concerned with deleting repeated elements from a sorted array.
For example, for the array (2,3,5,5,7,11,11,11,13), then after deletion, the array is
(2,3,5,7,11,13,0,0,0). After deleting repeated elements, there are 6 valid entries.
There are no requirements as to the values stored beyond the last valid element.

Write a program which takes as input a sorted array and updates it so that all dupli¬
cates have been removed and the remaining elements have been shifted left to fill the
emptied indices. Return the number of valid elements. Many languages have library
functions for performing this operation—you cannot use these functions.

Hint: There is an0(n) time and 0(1) space solution.
 */

import java.util.Arrays;

public class DeleteDupsSortedArray {

  public static void main(String[] args) {
    int[] input = new int[] { 2, 3,5,5,7,11,11,11,13 };

    System.out.println("Input: " + Arrays.toString(input));
    deleteDups(input);
    System.out.println("After dups deleted: " + Arrays.toString(input));
  }

  private static void deleteDups(int[] input) {
    int nextInsertionPoint = 1;
    for (int i=1, prev=input[0]; i<input.length; i++) {
      if (input[i] != prev) {
        input[nextInsertionPoint] = input[i];
        prev = input[i];
        nextInsertionPoint++;
      }
    }

    for (int i=nextInsertionPoint; i<input.length; i++) {
      input[i] = 0;
    }
  }
}
