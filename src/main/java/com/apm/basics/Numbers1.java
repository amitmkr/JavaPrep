package com.apm.basics;

// ----------------------------------------------------------
// Import Static allows static functions to be used directly
// ----------------------------------------------------------
import static com.apm.utils.Compare.*;

class MultiplePrivateClassesAllowed {}
class ButOnlyOnePublicClassAllowed {}

public class Numbers1 {

  public static void main(String[] args) {

    System.out.println(Numbers1.class.getName());

    Long longWithTrailingL  = 10L;      verifyEquality(longWithTrailingL,   10L);
    int octaWithPrefixO     = 020;      verifyEquality(octaWithPrefixO,     16);
    int hexaWithPrefix0x    = 0x30;     verifyEquality(hexaWithPrefix0x,    48);
    int binaryWithPrefix0B  = 0B0110;   verifyEquality(binaryWithPrefix0B,  6);
    int underScoreIsOk      = 1_000_0;  verifyEquality(underScoreIsOk,      10000);

    float floatWithSuffixF    = 3.14F;
    double defaultIsDouble    = 3.14;    // doesn't complie with "float", so default id DOUBLE
    double doubleWithSuffixD  = 3.14D;

    verifyEquality(floatWithSuffixF, 3.14F);
    verifyEquality(defaultIsDouble, 3.14);
    verifyEquality(doubleWithSuffixD, 3.14);

    double divideByZeroForDoubleIsInfinity = 100.0D / 0D;  // would raise DivideByZero for Integers
    verifyEquality(divideByZeroForDoubleIsInfinity, Double.POSITIVE_INFINITY);

    double divideByZeroForNumeratorZeroIsNAN = 0.0D / 0D;  // would raise DivideByZero for Integers
    verifyEquality(divideByZeroForNumeratorZeroIsNAN, Double.NaN);
  }
}
