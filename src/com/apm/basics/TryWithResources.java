package com.apm.basics;

import java.util.Arrays;

class MyNonAutoCloseable {
  public void release() throws Exception {
    System.out.println("Inside NonCloseable Release");
    throw new Exception("Exception thrown from release()");
  }
}

class MyCloseableResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("Inside MyCloseableResource Close");
    throw new Exception("Exception thrown from close()");
  }
}

class MyOtherCloseableResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("Inside MyOtherCloseableResource Close");
  }
}

public class TryWithResources {

  public static void main(String[] args) {

    System.out.println(TryWithResources.class.getName());

    // First, try with non-AutoCloseable
    // Exception thrown from FINALLY OVERRIDES the exception thrown from try
    try {
      System.out.println("----- Testing NonCloseable -----");
      testNonAutoCloseable();
    }
    catch (Exception e) {
      System.out.println("Caught NonCloseable Exception: " + e.getMessage());
    }

    // Next, try with AutoCloseable
    // Exception thrown from FINALLY is added to SUPPRESSED, and ORIGINAL exception is CAUGHT
    try {
      System.out.println("----- Testing AutoCloseable -----");
      testAutoCloseable();
    }
    catch (Exception e) {
      System.out.println("Caught Closeable Exception: " + e.getMessage());
      System.out.println("Below are the suppressed exceptions:");
      Arrays.stream(e.getSuppressed()).forEach(System.out::println);
    }
  }

  private static void testNonAutoCloseable() throws Exception {
    MyNonAutoCloseable nonAutoCloseable = new MyNonAutoCloseable();
    try {
      System.out.println("Inside NonCloseable Try");
      throw new Exception("Exception thrown from try for NonAutoCloseable");
    }
    finally {
      System.out.println("Inside NonCloseable Finally");
      nonAutoCloseable.release();
    }
  }

  private static void testAutoCloseable() throws Exception {
    try (
          MyCloseableResource closeable1 = new MyCloseableResource();
          MyOtherCloseableResource closeable2 = new MyOtherCloseableResource(); // Can contain MULTIPLE resources
    ) {
      System.out.println("Inside Closeable Try");
      throw new Exception("Exception thrown from try for NonAutoCloseable");
    }
    finally {
      System.out.println("Inside Closeable Finally");
    }
  }
}
