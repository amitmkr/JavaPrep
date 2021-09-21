package com.apm._lib;


import java.util.HashSet;
import java.util.Set;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public ListNode addNext(int x) {
    next = new ListNode(x);
    return next;
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
