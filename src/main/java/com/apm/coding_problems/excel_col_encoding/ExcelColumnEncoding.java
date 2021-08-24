package com.apm.coding_problems.excel_col_encoding;

/*
Spreadsheets often use an alphabetical encoding of the successive columns. Specif¬
ically, columns are identified by "A", "B", "C", ..., "X", "Y", "Z", "AA", "AB", ...,
"ZZ", "AAA", "AAB",....

Implement a function that converts a spreadsheet column id to the corresponding
integer, with "A" corresponding to 1. For example, you should return 4 for "D", 27
for "AA", 702 for "ZZ", etc. How would you test your code?
 */
public class ExcelColumnEncoding {

  public static void main(String[] args) {
    System.out.println(getSpreadsheetColumn("ZZ"));
  }

  /*
  Look at some samples.
  a=1     z=26
  aa=27   az=52
  ba=53   bz=78
  ca=79   cz=104

  General formula: ca = (c*26)+a = (3*26)+1 = 79
  zz = (z*26)+z = (26*26)+26 = 702

  aaa = (a*26^2) + (a*26^1) + a = (26*26) + 26 + 1 = 703

  za = (z*26^1)+a = (26*26)+1 = 677
  zza = zz+a = 702+1 = 703
      = (z*26^2) + (z*26^1) + 1 =
  zzz = (z*26)+z
   */
  public static int getSpreadsheetColumn(String columnEncoding) {
    final int ordinal_a = Character.getNumericValue('A');

    int encodedNumber = 0;

    for (int i=columnEncoding.length()-1, multiplier=0; i>=0; i--, multiplier++) {
      int ordinal = Character.getNumericValue(columnEncoding.charAt(i)) - ordinal_a + 1;

      encodedNumber = (int)(encodedNumber * Math.pow(26, multiplier) + ordinal);
    }

    return encodedNumber;
  }
}
