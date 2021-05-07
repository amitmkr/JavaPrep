package com.apm.coding_problems.look_and_say;

/*
The look-and-say sequence starts with 1. Subsequent numbers are derived by de¬
scribing the previous number in terms of consecutive digits. Specifically, to generate
an entry of the sequence from the previous entry, read off the digits of the previ¬
ous entry, counting the number of digits in groups of the same digit. For exam¬
ple, 1; one 1; two Is; one 2 then one 1; one 1, then one 2, then two Is; three Is,
then two 2s, then one 1. The first eight numbers in the look-and-say sequence are
<1,11,21,1211,111221,312211,13112221,1113213211>.

Write a program that takes as input an integer n and returns the nth integer in the
look-and-say sequence. Return the result as a string.
 */

import java.util.Scanner;

public class LookAndSay {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    boolean validInput = true;
    while (validInput == true) {
      System.out.print("Enter number (e to exit): ");
      String number = scanner.nextLine();
      if (number.equalsIgnoreCase("e"))
        validInput = false;
      else {
        sayTheNumber(number, 10);
      }
    }
  }

  private static void sayTheNumber(String number, int numTimes) {
    String currentNumber = number;
    for (int n=0; n<numTimes; n++) {
      StringBuilder sb = new StringBuilder();
      char currentChar = currentNumber.charAt(0);
      int charCounter = 1;
      for (int pos=1; pos<currentNumber.length(); pos++) {
        if (currentChar == currentNumber.charAt(pos)) {
          charCounter++;
        }
        else {
          sb.append(charCounter);
          sb.append(currentChar);

          charCounter = 1;
          currentChar = currentNumber.charAt(pos);
        }
      }

      sb.append(charCounter);
      sb.append(currentChar);

      currentNumber = sb.toString();
      System.out.print(currentNumber + ", ");
    }
    System.out.println("DONE");
  }
}
