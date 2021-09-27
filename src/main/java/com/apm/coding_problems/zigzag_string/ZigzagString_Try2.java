package com.apm.coding_problems.zigzag_string;


// Below solution uses arithmetic to pick the correct chars. Can work with O(1) space if string is directly output

/*
LOGIC:

T         y          g
h       r L       n  W
i     e   o     i    r
s   V     n   r      i
I A       g t        t
s         S          t

01              11             21
02          10  12          20 22
03       09     13       19    23
04    08        14    18       24
05 07           15 17          25
06              16             26

Consider the above example. The first print on any row is considered ODD, the second print EVEN and so on.

The first row always has a gap of n+(n-2) characters for both odd & even. Same for the last row.
n+(n-1) = 6+(6-2) = 10
1st row is 01+10 = 11, 11+10=21. Last row is 06+10=16, 16+10=26

From the next row onwards, the ODD spacing decreases by 2, and the EVEN spacing is FIRST_ODD_SPACING - CURRENT_ODD_SPACING

Take the 3rd row. Odd spacing will be 10-2-2=6 and Even spacing will be 10-6=4
Hence, 03+6=09, 09+4=13, 13+6=19, 19+4=23

 */

public class ZigzagString_Try2 {

  public static void main(String[] args) {
    verifyZigZagConversion("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
    verifyZigZagConversion("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
    verifyZigZagConversion("ThisIsAVeryLongStringWrittenSpecificallyToTestASubstantiallyLongString", 12,
      "TrsrhWiettiigtTASnsntoSggIieTunsrnyboAtSlsLVSpltyegeaalrnccnlyoiitaLfi");
    verifyZigZagConversion("ThisIsAVeryLongStringWrittenSpecificallyToTestASubstantiallyLongString", 11,
      "TgTLhnWyoyoiirlTlnsrilelgIttasaSsStctitAgeiAtrVnnfSnieoSiuanrLpcbtgyes");
    verifyZigZagConversion("ThisIsAVeryLongStringWrittenSpecificallyToTestASubstantiallyLongString", 4,
      "TAoiteaTutLrhsVLnrnitpccloeSbniyotiiIeygtgreSiilTsAsaalnSnsrSWnfyttlgg");
  }

  private static boolean verifyZigZagConversion(String input, int numRows, String expectedOutput) {
    String output = getZigzagPattern(input, numRows);
    boolean result = expectedOutput.equals(output);
    System.out.println("Input=" + input + " Rows=" + numRows + " Expected=" + expectedOutput + " Output=" + output + " MATCH=" + result);
    return result;
  }

  private static String getZigzagPattern(String str, int numRows) {
    StringBuilder builder = new StringBuilder();
    int firstRowSpacing = numRows + (numRows - 2);

    int oddCharSpacing = firstRowSpacing;
    int evenCharSpacing = firstRowSpacing;
    int currentRow = 0;
    while (currentRow < numRows) {
      System.out.println("Row=" + currentRow + " Odd=" + oddCharSpacing + " Even=" + evenCharSpacing);
      int charPos = currentRow;
      boolean isOddIteration = true;
      while (charPos < str.length()) {
        //System.out.println(str.charAt(charPos));
        builder.append(str.charAt(charPos));
        charPos += isOddIteration ? oddCharSpacing : evenCharSpacing;
        isOddIteration = ! isOddIteration;
      }

      oddCharSpacing -= 2;
      evenCharSpacing = firstRowSpacing - oddCharSpacing;
      if (oddCharSpacing == 0) {
        oddCharSpacing = evenCharSpacing;
      }

      ++currentRow;
    }

    return builder.toString();
  }
}
