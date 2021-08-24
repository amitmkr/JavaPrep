package com.apm.utils;

public class Compare {

  public static <T extends Comparable<T>> void verifyEquality(T t1, T t2) {
    if (t1 == null && t2 == null) {
      return;
    }
    else if ( (t1 == null && t2 != null) ||
              (t2 == null && t1 != null) ||
              (t1.compareTo(t2) != 0) ) {
      throw new Error("NOT EQUAL - " + t1 + " != " + t2);
    }
  }
/*
  public static void verifyEquality(Number num1, Number num2) {
    if (num1.equals(num2)) {
      throw new Error("NOT EQUAL - " + num1 + " != " + num2);
    }
  }
*/

/*
  public static void verifyEquality(Long num1, Long num2) {
    if (num1 != num2) {
      throw new Error("NOT EQUAL - " + num1 + " != " + num2);
    }
  }

  public static void verifyEquality(Double num1, Double num2) {
    if (Math.abs(num1-num2) > 0.01) {
      throw new Error("NOT EQUAL - " + num1 + " != " + num2);
    }
  }
*/

  public static void verifyEquality(Boolean bool1, Boolean bool2) {
    if (Boolean.compare(bool1, bool2) != 0) {
      throw new Error("NOT EQUAL - " + bool1 + " != " + bool2);
    }
  }

/*  public static void verifyEquality(Object obj1, Object obj2) {
    if (! obj1.equals(obj2)) {
      throw new Error("NOT EQUAL - " + obj1 + " != " + obj2);
    }
  }*/

}
