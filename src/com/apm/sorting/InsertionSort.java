package com.apm.sorting;

import java.util.Arrays;

public class InsertionSort {

  private static void swap(int[] numbers, int pos1, int pos2) {
    int temp = numbers[pos1];
    numbers[pos1] = numbers[pos2];
    numbers[pos2] = temp;
  }

  static void Sort(int[] numbers) {
    for (int i=1; i < numbers.length; i++) {
      for (int j=i-1; j >= 0; j--) {
        if (numbers[j] > numbers[j+1]) {
          swap(numbers, j, j+1);
        }

        System.out.println("(i=" + i + ",j=" + j + ") - " + Arrays.toString(numbers));
      }
      System.out.println(("Iteration " + i + ": " + Arrays.toString(numbers)));
    }
  }

  public static void main(String[] args) {
    int[] numbers = { 23, 66, 9, 12, 87, 24, 2, 10 };

    System.out.println("INITIAL: " + Arrays.toString(numbers));

    Sort(numbers);

    System.out.println("SORTED: " + Arrays.toString(numbers));
  }
}