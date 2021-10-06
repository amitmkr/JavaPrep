package com.apm.coding_problems.reverse_linked_list;

import com.apm._lib.ListNode;

import java.util.List;

public class ReverseLinkedList_Recursively {

  public static void main(String[] args) {
    reverse_linked_list(1, 2, 3, 4, 5);
    reverse_linked_list(1);
    reverse_linked_list();
  }

  private static ListNode reverse_linked_list(int... values) {
    ListNode root = null;
    if (values.length > 0) {
      root = new ListNode(values[0]);
      ListNode current = root;
      for (int i=1; i< values.length; i++) {
        current.addNext(values[i]);
        current = current.next;
      }
      current.next = null;
    }

    System.out.println("Original list: " + (root == null ? "[EMPTY]" : root.toString()));

    ListNode reversedList = reverse_linked_list_recursively(root);
    System.out.println("Reversed list: " + (reversedList == null ? "[EMPTY]" : reversedList.toString()));

    return reversedList;
  }

  private static class ReturnVal {
    ListNode newRoot;
    ListNode parent;

    ReturnVal(ListNode newRoot, ListNode parent) {
      this.newRoot = newRoot;
      this.parent = parent;
    }
  }
  private static ListNode reverse_linked_list_recursively(ListNode root) {
    return root == null ? null : internal_reverse_linked_list(root).newRoot;
  }

  private static ReturnVal internal_reverse_linked_list(ListNode node) {
    if (node.next == null) {
      return new ReturnVal(node, node);
    }
    ReturnVal retVal = internal_reverse_linked_list(node.next);
    retVal.parent.next = node;
    node.next = null;
    retVal.parent = node;
    return retVal;
  }
}
