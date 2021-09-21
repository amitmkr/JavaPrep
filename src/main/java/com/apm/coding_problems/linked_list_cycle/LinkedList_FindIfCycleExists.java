package com.apm.coding_problems.linked_list_cycle;

import com.apm._lib.ListNode;

public class LinkedList_FindIfCycleExists {

  public static void main(String[] args) {
    ListNode root = new ListNode(3);

    root.addNext(2).addNext(0).addNext(-4);

    System.out.println("Orig List: " + root.toString());
    System.out.println(hasCycles(root));

    root.next.next.next.next = root;

    System.out.println("Modified List: " + root.toString());
    System.out.println(hasCycles(root));
  }

  static boolean hasCycles(ListNode root) {
    ListNode slowPtr = root, fastPtr = root.next;

    while (slowPtr != null && fastPtr != null && slowPtr != fastPtr) {
      //System.out.println(slowPtr.val + " - " + fastPtr.val);
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next != null ? fastPtr.next.next : null;
    }

    return slowPtr == fastPtr;
  }
}
