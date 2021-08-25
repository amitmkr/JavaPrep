package com.apm.utils;

import java.util.Arrays;

public class PrintHelper {

  public static <T> void Print2dArray(T[][] obj2dArray) {
    System.out.println(Arrays.deepToString(obj2dArray).replace("],", "]\n"));
  }

  public static void Print2dArray(int[][] int2dArray) {
    System.out.println(Arrays.deepToString(int2dArray).replace("],", "]\n"));
  }

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

    Print2dArray(grid);
  }
}
