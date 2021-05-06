package com.apm.coding_problems.merge_sorted_arrays;

/*
Write a program which merges two sorted arrays of integers, A and B.
Specifically, the final result should be a sorted array of length m + n, where n and
m are the lengths of A and B, respectively.

Use 0(1) additional storage—assume the result is stored in A, which has sufficient space.
These arrays are C-style arrays, i.e., contiguous preallocated blocks of memory.
 */

import java.util.Arrays;

public class MergeSortedArrays {

  private static void mergeArrays(int[] array1, int numElementsArray1, int[] array2) {
    int numFinalElementsArray1 = numElementsArray1 + array2.length;

    int array1ReadPos = numElementsArray1 - 1;
    int array2ReadPos = array2.length - 1;

    for (int i=numFinalElementsArray1-1; i>=0; i--) {
      if (array1ReadPos >=0 && array2ReadPos >=0) {
        if (array1[array1ReadPos] > array2[array2ReadPos]) {
          array1[i] = array1[array1ReadPos];
          array1ReadPos--;
        }
        else {
          array1[i] = array2[array2ReadPos];
          array2ReadPos--;
        }
      }
      else if (array1ReadPos >= 0) {
        array1[i] = array1[array1ReadPos];
        array1ReadPos--;
      }
      else if (array2ReadPos >= 0) {
        array1[i] = array2[array2ReadPos];
        array2ReadPos--;
      }
    }
  }

  public static void main(String[] args) {
    int[] array1 = new int[] { 10, 20, 30, 40, 50, -1, -1, -1, -1, -1, -1, -1 };

    int[] array2 = new int[] { 5, 12, 18, 34, 42 };

    System.out.println("Original Array1: " + Arrays.toString(array1));
    System.out.println("Original Array2: " + Arrays.toString(array2));

    mergeArrays(array1, 5, array2);

    System.out.println("Modified Array1: " + Arrays.toString(array1));
    System.out.println("Modified Array2: " + Arrays.toString(array2));
  }
}
