package com.apm.sorting;

import java.util.Arrays;

public class SelectionSort {

  public static int Sort(int[] numbers) {
    int totalNumbers = numbers.length;
    System.out.println("Starting Selection Sort for: " + Arrays.toString(numbers));


    for (int i=0; i<totalNumbers; i++) {
      for (int j=i; j<totalNumbers; j++) {
        if (numbers[i] > numbers[j]) {
          int temp = numbers[i];
          numbers[i] = numbers[j];
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

    System.out.println("INITIAL: " + Arrays.toString(numbers));

    Sort(numbers);

    System.out.println("SORTED: " + Arrays.toString(numbers));
  }
}
