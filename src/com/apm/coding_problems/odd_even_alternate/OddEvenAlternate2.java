package com.apm.coding_problems.odd_even_alternate;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenAlternate2 {

  private static AtomicInteger nextEven = new AtomicInteger(0);
  private static AtomicInteger nextOdd = new AtomicInteger(-1);
  private static AtomicBoolean allDone = new AtomicBoolean(false);
  private static CyclicBarrier barrier;

  public static void main(String[] args) throws InterruptedException {

    Thread evenThread = new Thread(() -> {
      try {
        while (! allDone.get()) {
          nextEven.updateAndGet(num -> num + 2);
          barrier.await();
        }
      }
      catch (Exception e) {}
    });

    Thread oddThread = new Thread(() -> {
      try {
        while (! allDone.get()) {
          nextOdd.updateAndGet(num -> num + 2);
          barrier.await();
        }
      } catch (Exception e) {}
    });

    barrier = new CyclicBarrier(2, () -> {
      System.out.println(nextEven.get());
      System.out.println(nextOdd.get());
      if (nextEven.get() >= 50) { allDone.set(true); }
    });

    evenThread.start();
    oddThread.start();

    evenThread.join();
    oddThread.join();
  }
}
