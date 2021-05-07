package com.apm.coding_problems.phone_number_mnemonics;

/*
Each digit, apart from 0 and 1, in a phone keypad corresponds to one of three or four
lettersof the alphabet, asshown in Figure 7.1on the next page. Since wordsare easier
to remember than numbers, it is natural to ask if a 7 or 10-digit phone number can
be represented by a word. For example, "2276696" corresponds to "ACRONYM" as
well as "ABPOMZN".

Write a program which takes asinput a phone number, specified as a string of digits,
and returns all possible character sequences that correspond to the phone number.
The cell phone keypad is specified by a mapping that takes a digit and returns the
corresponding set of characters. The character sequences do not have to be legal
words or phrases.

1 -
2 - A B C
3 - D E F
4 - G H I
5 - J K L
6 - M N O
7 - P Q R S
8 - T U V
9 - W X Y Z
0 -
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberMnemonics {

  public static void main(String[] args) {
    ArrayList<String> mnemonics = convertNumberToMnemonics("2276696");
    System.out.println("Mnemonics are: " + mnemonics);
  }

  private static HashMap<Integer, List<Character>> MNEMONIC_MAP;

  private static void InitMnemonicMap() {
    MNEMONIC_MAP = new HashMap<>();
    MNEMONIC_MAP.put(2, Arrays.asList('A', 'B', 'C'));
    MNEMONIC_MAP.put(3, Arrays.asList('D', 'E', 'F'));
    MNEMONIC_MAP.put(4, Arrays.asList('G', 'H', 'I'));
    MNEMONIC_MAP.put(5, Arrays.asList('J', 'K', 'L'));
    MNEMONIC_MAP.put(6, Arrays.asList('M', 'N', 'O'));
    MNEMONIC_MAP.put(7, Arrays.asList('P', 'Q', 'R', 'S'));
    MNEMONIC_MAP.put(8, Arrays.asList('T', 'U', 'V'));
    MNEMONIC_MAP.put(9, Arrays.asList('X', 'Y', 'Z'));
  }

  private static ArrayList<String> convertNumberToMnemonics(String number) {
    InitMnemonicMap();
    ArrayList<String> mnemonics = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    for (char ch1 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(0)))) {
      sb.append(ch1);
      for (char ch2 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(1)))) {
        sb.append(ch2);
        for (char ch3 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(2)))) {
          sb.append(ch3);
          for (char ch4 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(3)))) {
            sb.append(ch4);
            for (char ch5 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(4)))) {
              sb.append(ch5);
              for (char ch6 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(5)))) {
                sb.append(ch6);
                for (char ch7 : MNEMONIC_MAP.get(Character.getNumericValue(number.charAt(6)))) {
                  sb.append(ch7);
                  mnemonics.add(sb.toString());
                  sb.deleteCharAt(6);
                }
                sb.deleteCharAt(5);
              }
              sb.deleteCharAt(4);
            }
            sb.deleteCharAt(3);
          }
          sb.deleteCharAt(2);
        }
        sb.deleteCharAt(1);
      }
      sb.deleteCharAt(0);
    }

    return mnemonics;
  }
}
