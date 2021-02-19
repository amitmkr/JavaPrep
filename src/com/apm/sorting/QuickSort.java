package com.apm.sorting;

import java.util.Arrays;

public class QuickSort {

  private static void swap(int[] numbers, int pos1, int pos2) {
    int temp = numbers[pos1];
    numbers[pos1] = numbers[pos2];
    numbers[pos2] = temp;
  }

  private static int partition(int[] numbers, int start, int end) {
    System.out.println("Partition: start=" + start + " end=" + end);

    // We are not going to move pivot during the run
    // The strategy is to start accumulating smaller numbers at the begining of the array
    //  and leave larger numbers in place.
    // Once the loop ends, swap the number next to the smaller number with the pivot

    int currentPivotPos = end;
    int pivot = numbers[currentPivotPos];

    int smallNumberPos = start - 1;
    for (int i=start; i<currentPivotPos; i++) {
      if (numbers[i] < pivot) {
        smallNumberPos++;
        swap(numbers, smallNumberPos, i);
      }
      // else, if larger number, move to the next element keeping smallNumPos as-is for the next swap
    }

    swap(numbers, smallNumberPos+1, currentPivotPos);

    return smallNumberPos+1;
  }

  private static void internal_quicksort(int[] numbers, int start, int end) {
    System.out.println("QuickSort. start=" + start + " end=" + end);
    if (start < end) {
      int pivotPos = partition(numbers, start, end);

      System.out.println("After Partition. PivotPos=" + pivotPos + " Numbers=" + Arrays.toString(numbers));

      internal_quicksort(numbers, start, pivotPos-1);
      internal_quicksort(numbers, pivotPos+1, end);
    }
  }

  static void Sort(int[] numbers) {
    internal_quicksort(numbers, 0, numbers.length-1);
  }

  public static void main(String[] args) {
    int[] numbers = { 23, 66, 9, 12, 87, 24, 2, 10 };

    System.out.println("INITIAL: " + Arrays.toString(numbers));

    Sort(numbers);

    System.out.println("SORTED: " + Arrays.toString(numbers));
  }
}
