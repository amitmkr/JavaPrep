package com.apm.coding_problems.zigzag_string;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ZigzagString {
  public static void main(String[] args) {
    String str = "PAYPALISHIRING";
    int numRows = 4;
    System.out.println(getZigzagPattern(str, numRows));
  }

  private static String getZigzagPattern(String str, int numRows) {
    StringBuilder[] stringRows = new StringBuilder[numRows];
    IntStream.range(0,numRows).forEach(i -> stringRows[i] = new StringBuilder());

    final int UP=0, DOWN=1;
    int direction = DOWN, currentRow = 0;
    for (char ch : str.toCharArray()) {
      stringRows[currentRow].append(ch);

      int nextRowInZigzag = (direction == DOWN ? currentRow + 1 : currentRow - 1);
      if (nextRowInZigzag < 0) { direction = DOWN; currentRow=1; }
      else if (nextRowInZigzag >= numRows) { direction = UP; currentRow=numRows-2; }
      else { currentRow = nextRowInZigzag; }

      if (currentRow < 0) currentRow = 0;
      else if (currentRow >= numRows) currentRow = numRows - 1;
    }
    
    StringBuilder result = new StringBuilder();
    for (StringBuilder row : stringRows) {
      result.append(row.toString());
    }
    
    return result.toString();
  }
}
