package com.apm._lib;


import java.util.HashSet;
import java.util.Set;

public class ListNode {
  public long val;
  public ListNode next;

  public ListNode(long x) {
    val = x;
    next = null;
  }

  public ListNode addNext(int x) {
    next = new ListNode(x);
    return next;
  }

  // If list is 3->2->1, returns the number 123
  public long getReverseNumber() {
    long number = val;
    int numDigit = 1;

    ListNode temp = next;
    while (temp != null) {
      number = number + ( (long)(Math.pow(10, numDigit)) * temp.val );
      numDigit++;
      temp = temp.next;
    }
    return number;
  }

  // Given number 123, will return list 3->2->1
  public static ListNode ofNumber(long number) {
    ListNode numberAsList = new ListNode(0);

    long remainder = number;
    ListNode current = numberAsList;
    while (remainder != 0) {
      current.next = new ListNode(remainder % 10);
      current = current.next;

      remainder = remainder / 10;
    }

    return number == 0 ? numberAsList : numberAsList.next;
  }

  public static ListNode ofNumber(String numberAsString) {
    ListNode numberAsList = new ListNode(0);

    ListNode current = numberAsList;
    for (int pos=numberAsString.length()-1; pos>=0; pos--) {
      int digit = Integer.valueOf(String.valueOf(numberAsString.charAt(pos)));
      current.next = new ListNode(digit);
      current = current.next;
    }

    return numberAsString.isEmpty() ? numberAsList : numberAsList.next;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    Set<ListNode> visitedNodes = new HashSet<>();

    boolean cycleFound = false;
    ListNode temp = this;
    while (temp != null && ! cycleFound) {
      builder.append("[").append(temp.val).append("]").append("->");

      cycleFound = ! visitedNodes.add(temp);

      temp = temp.next;
    }

    builder.append(cycleFound ? "CYCLE" : "NULL");
    return builder.toString();
  }
}
