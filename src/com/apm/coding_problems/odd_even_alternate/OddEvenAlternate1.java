package com.apm.coding_problems.odd_even_alternate;

import java.util.concurrent.Exchanger;

public class OddEvenAlternate1 {

  //private static Integer evenObj1=0, evenObj2=0;
  //private static Integer oddObj1=0, oddObj2=0;
  private static Integer evenObj = 0, oddObj = -1;

  private static Exchanger<Integer> evenExchanger = new Exchanger<>();
  private static Exchanger<Integer> oddExchanger = new Exchanger<>();

  public static void main(String[] args) throws InterruptedException {
    Thread evenThread = new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            do { evenObj += 2; evenExchanger.exchange(evenObj); } while (evenObj <= 50);
            evenExchanger.exchange(null);
          } catch (InterruptedException e) {}
        }
      }
    );

    Thread oddThread = new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            do { oddObj += 2; oddExchanger.exchange(oddObj); } while (oddObj <= 50);
            oddExchanger.exchange(null);
          } catch (InterruptedException e) {}
        }
      }
    );

    Thread printThread = new Thread(
      new Runnable() {
        @Override
        public void run() {
          boolean evenThreadDone=false, oddThreadDone=false;
          try {
            while (!evenThreadDone && !oddThreadDone) {
              Integer evenNum, oddNum;
              evenNum = evenExchanger.exchange(null); System.out.println(evenNum);
              oddNum = oddExchanger.exchange(null); System.out.println(oddNum);

              evenThreadDone = (evenNum == null);
              oddThreadDone = (oddNum == null);
            }
          }
          catch (InterruptedException e) {}
        }
      }
    );

    evenThread.start();
    oddThread.start();
    printThread.start();

    evenThread.join();
    oddThread.join();
    printThread.join();
  }
}
