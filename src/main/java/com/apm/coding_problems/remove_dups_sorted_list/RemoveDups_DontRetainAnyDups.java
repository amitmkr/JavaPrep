package com.apm.coding_problems.remove_dups_sorted_list;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
**** leaving only distinct numbers **** from the original list.
Return the linked list sorted as well.

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Input: head = [1,1,1,2,3]
Output: [2,3]
 */

import com.apm._lib.ListNode;

public class RemoveDups_DontRetainAnyDups {
  public static void main(String[] args) {
    ListNode rootExample1 = new ListNode(1);
    rootExample1.addNext(2).addNext(3).addNext(3).addNext(4).addNext(4).addNext(5);
    System.out.println("Example 1 list is: " + rootExample1);
    rootExample1 = fullyRemoveDups(rootExample1);
    System.out.println("Example 1 modified list is: " + rootExample1);

    System.out.println();
    ListNode rootExample2 = new ListNode(1);
    rootExample2.addNext(1).addNext(1).addNext(2).addNext(3);
    System.out.println("Example 2 list is: " + rootExample2);
    rootExample2 = fullyRemoveDups(rootExample2);
    System.out.println("Example 2 modified list is: " + rootExample2);

    System.out.println();
    ListNode rootExample3 = new ListNode(1);
    rootExample3.addNext(1).addNext(1).addNext(2).addNext(2).addNext(3);
    System.out.println("Example 3 list is: " + rootExample3);
    rootExample3 = fullyRemoveDups(rootExample3);
    System.out.println("Example 3 modified list is: " + rootExample3);

    System.out.println();
    ListNode rootExample4 = new ListNode(1);
    rootExample4.addNext(1).addNext(1).addNext(2).addNext(2).addNext(3).addNext(3);
    System.out.println("Example 4 list is: " + rootExample4);
    rootExample4 = fullyRemoveDups(rootExample4);
    System.out.println("Example 4 modified list is: " + rootExample4);
  }

  private static ListNode fullyRemoveDups(ListNode root) {
    if (root == null) return root;

    ListNode newRoot = getNewRoot(root);
    if (newRoot == null) return newRoot;

    // At this stage, we know that root contains some value, and the element
    // after root is not a dup of root.

    ListNode previous = newRoot, current = newRoot.next;
    while (current != null) {
      if (previous.val != current.val) {
        // Skip over dups and assign next of previous non-dup to current
        previous.next = current;
        // Move to the next value change and re-check dups for this new value
        previous = current;
      }
      current = current.next;
    }
    previous.next = null;
    return newRoot;
  }

  private static ListNode getNewRoot(ListNode root) {
    if (root == null) return root;
    
    ListNode current = root, next = root.next;

    boolean checkForDupRoot = true;

    while (checkForDupRoot &&  next != null) {
      current = root;
      next = root.next;
      while (next != null && next.val == current.val) {
        next = next.next;
      }

      if (next == null) {
        // Reached end of list, no non-dup elements found
        return null;
      }
      else if (current.next != next) {
        // Found first differing element after root duplication
        // Change root, and check the new root for dups
        root = next;
        checkForDupRoot = true;
        next = root.next;
      }
      else {
        // Non-dup element now in root
        checkForDupRoot = false;
      }
    }
    
    return root;
  }
}
