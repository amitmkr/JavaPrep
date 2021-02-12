package com.apm.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static int Sort(int[] numbers) {
    int totalNumbers = numbers.length;
    System.out.println("Starting Bubble Sort for: " + Arrays.toString(numbers));


    for (int i=0; i<totalNumbers; i++) {
      for (int j=0; j<totalNumbers-i-1; j++) {
        if (numbers[j] > numbers[j+1]) {
          int temp = numbers[j+1];
          numbers[j+1] = numbers[j];
          numbers[j] = temp;
        }

        System.out.println("(i=" + i + ",j=" + j + ") - " + Arrays.toString(numbers));
      }

      System.out.println(("Interation " + i + ": " + Arrays.toString(numbers)));
    }

    return 0;
  }

  public static void main(String[] args) {
    int[] numbers = { 23, 66, 9, 12, 87, 24, 2, 10 };

    Sort(numbers);

    System.out.println("SORTED: " + Arrays.toString(numbers));
  }
}
