package com.apm.coding_problems.moveZerosToEnd;

import jdk.dynalink.linker.LinkerServices;

import java.util.Arrays;

public class MoveZerosToEnd2 {

  public static void main(String[] args) {
    System.out.println("ABCD");

    int[] inputArray = { 0, 0, 10, 0, 20, 0, 0, 0, 30, 0, 0, 40, 0, 0 };
    System.out.println(Arrays.toString(inputArray));
    moveZerosToEnd(inputArray);
    System.out.println(Arrays.toString(inputArray));
  }

  private static void moveZerosToEnd(int[] inputArray) {
    int length = inputArray.length;

    int insertionPoint = -1;

    for (int i=0; i < length; i++) {
      if (inputArray[i] != 0) {
        insertionPoint++;
        inputArray[insertionPoint] = inputArray[i];
      }
    }

    for (int i=insertionPoint+1; i<length; i++) {
      inputArray[i] = 0;
    }
  }
}
