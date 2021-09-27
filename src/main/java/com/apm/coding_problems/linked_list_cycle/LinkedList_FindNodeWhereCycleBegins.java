package com.apm.coding_problems.linked_list_cycle;

import com.apm._lib.ListNode;

/*
https://leetcode.com/problems/linked-list-cycle-ii/

Given the head of a linked list, return the node where the cycle begins.
If there is no cycle, return null

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class LinkedList_FindNodeWhereCycleBegins {

  public static void main(String[] args) {
    ListNode root = new ListNode(3);

    root.addNext(2).addNext(0).addNext(-4);

    System.out.println("Orig List: " + root.toString());
    System.out.println(findCycleStart(root));

    root.next.next.next.next = root.next;

    System.out.println("Modified List: " + root.toString());
    System.out.println(findCycleStart(root));
  }

  private static ListNode findCycleStart(ListNode root) {
    // This is important for the rest of the algo to work.
    // There cannot be a diff of more than 1 between slow/fast when the cycle detection starts
    ListNode slowPtr = root.next, fastPtr = root.next.next;

    while (fastPtr != null && slowPtr != fastPtr) {
      //System.out.println(slowPtr.val + " - " + fastPtr.val);
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next != null ? fastPtr.next.next : null;
    }

    // If cycle exists,
    if (slowPtr == fastPtr) {
      // Init slowPtr to head, keep fastPtr where it is.
      // Next, move both by 1. The point at which they meet is the start of the loop
      slowPtr = root;
      while (slowPtr != fastPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }

      return slowPtr;
    }
    else { return null; }
  }
}
