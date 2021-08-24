package com.apm.basics;

import static com.apm.utils.Compare.*;

class MyOuter {                         // private class MyOuter NOT ALLOWED, only Inner Class can be Private.
  private Integer outerClassInt = 556;

  private static Integer outerClassStaticInt = 774;

  // Non-static Inner Class
  private class NonStaticInner {        // INNER classes can be PRIVATE

    static final int someStatic = 20;  // All STATIC fields should be FINAL.

    NonStaticInner() {
      System.out.println("Initing: NonStaticInner");
      verifyEquality(outerClassInt, 556); // Can ACCESS OUTER PRIVATE
      verifyEquality(outerClassStaticInt, 774);
    }

    // static int getSomeStatic() { return someStatic; }  // STATIC METHODS NOT ALLOWED
  }

  // Static Inner Class
  static class StaticInner {
    StaticInner() {
      System.out.println("Initing: StaticInner");
      verifyEquality(outerClassStaticInt, 774);   // Can only access STATIC outers in STATIC class
    }
  }
}
public class InnerClassExample {

  public static void main(String[] args) {

    System.out.println(InnerClassExample.class.getName());

    System.out.println("Initing MyOuter ");
    MyOuter myo = new MyOuter();
  }
}
