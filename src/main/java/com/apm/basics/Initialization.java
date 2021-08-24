package com.apm.basics;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.apm.utils.Compare.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Initialization {

  @Test
  void array_of_numbers_is_initialized_to_zero() {
    int[] intArray = new int[5];
    assertAll(
      () -> assertEquals(0, intArray[0]),
      () -> assertEquals(0, intArray[4])
    );
  }

  public static void main(String[] args) {

    System.out.println(Initialization.class.getName());

    // Array of numbers is initialized with Zeros
    int[] intArray = new int[5];
    verifyEquality(intArray[3], 0);

    // Array of boolean is initialized with FALSE
    boolean[] boolArray = new boolean[5];
    verifyEquality(boolArray[2], false);

    // Normal initialization
    int[] initedArray = { 0, 1, 2, 3, 4 };
    verifyEquality(initedArray[4], 4);
    verifyEquality(initedArray.length, 5);

    // Array of length Zero is legal
    int[] zeroLenArray = {};
    verifyEquality(zeroLenArray.length, 0);
  }


}
