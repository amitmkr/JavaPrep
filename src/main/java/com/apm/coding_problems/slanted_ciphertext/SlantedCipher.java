package com.apm.coding_problems.slanted_ciphertext;

import java.util.Arrays;

public class SlantedCipher {

  public static void main(String[] args) {
    invokeAlgo("ch   ie   pr", 3, "cipher");
    invokeAlgo("iveo    eed   l te   olc", 4, "i love leetcode");
    invokeAlgo("coding", 1, "coding");
  }

  public static void invokeAlgo(String encodedText, int rows, String expectedText) {
    String output = decodeCiphertext(encodedText, rows);
    String result = output.equals(expectedText) ? "PASSED" : "FAILED";
    System.out.println(result + " EncodedText='" + encodedText + "', Rows=" + rows +
      ", Expected='" + expectedText + "'");
  }

  public static String decodeCiphertext(String encodedText, int rows) {
    int partitionSize = encodedText.length() / rows;

    char[] outputArray = new char[encodedText.length()];
    Arrays.fill(outputArray, ' ');

    int leadingSpaces = 0;
    for (int currentRow=0; currentRow<rows; ++currentRow, ++leadingSpaces) {
      int leadingSpacedSkipped = 0;
      int outputCharPos = leadingSpaces;
      for (int currentCol = 0; currentCol<partitionSize; ++currentCol) {
        if (leadingSpacedSkipped < leadingSpaces) {
          // Skip this character as its a leading space
          ++leadingSpacedSkipped;
          continue;
        }
        char nextChar = encodedText.charAt((currentRow * partitionSize) + currentCol);
        outputArray[outputCharPos] = nextChar;
        outputCharPos += rows;
      }
    }

    /**
     * How this works ?
     *
     * First break down the input string into rows (totalLen / rows)
     * This will create "iveo  " , "  eed " , "  l te", "   olc"
     *
     * Next, skip leading spaces. 1st row has Zero leading spaces, 2nd row has 1 etc.
     *
     * Now, the position to place the read char into the final string begins after leading spaces.
     * And, we jump for "rows" columns to place the next.
     *
     * Here's the string created per iteration (. shows spaces)
     *
     * Start    "........................"
     * Iter 1   "i...v...e...o..........."
     * Iter 2   "i...ve..ee..od.........."
     * Iter 3   "i.l.ve..eet.ode........."
     * Iter 4   "i.love.leetcode........."
     */

    String output = new String(outputArray);
    return output.stripTrailing();
  }
}


/**
 * https://leetcode.com/contest/weekly-contest-267/problems/decode-the-slanted-ciphertext/
 *
 * A string originalText is encoded using a slanted transposition cipher to a string encodedText
 * with the help of a matrix having a fixed number of rows rows.
 *
 * originalText is placed first in a top-left to bottom-right manner.
 * Text if filled diagonally in the matrix.
 * Next, the matrix is serialized by row to generate the final encrypted text.
 *
 * Given the encoded string encodedText and number of rows rows, return the original string originalText.
 *
 * Note: originalText does not have any trailing spaces ' '.
 * The test cases are generated such that there is only one possible originalText.
 *
 * Constraints:
 *     0 <= encodedText.length <= 106
 *     encodedText consists of lowercase English letters and ' ' only.
 *     encodedText is a valid encoding of some originalText that does not have trailing spaces.
 *     1 <= rows <= 1000
 *     The testcases are generated such that there is only one possible originalText.
 *
 * --------------------------------------------
 *
 * Example:
 *
 * originalText = "i love leetcode"
 * numRows = 4
 * spaces marked with %
 *
 * i v e o # #
 * # # e e d #
 * # # l # t e
 * # # # o l c
 *
 * (read diagonally from left top to right bottom)
 *
 * Example 1:
 * Input: encodedText = "ch   ie   pr", rows = 3
 * Output: "cipher"
 *
 * Example 2:
 * Input: encodedText = "iveo    eed   l te   olc", rows = 4
 * Output: "i love leetcode"
 * Explanation: The figure above denotes the matrix that was used to encode originalText.
 * The blue arrows show how we can find originalText from encodedText.
 *
 * Example 3:
 * Input: encodedText = "coding", rows = 1
 * Output: "coding"
 * Explanation: Since there is only 1 row, both originalText and encodedText are the same.
 *
 * Example 4:
 * Input: encodedText = " b  ac", rows = 2
 * Output: " abc"
 * Explanation: originalText cannot have trailing spaces, but it may be preceded by one or more spaces.
 *
 */