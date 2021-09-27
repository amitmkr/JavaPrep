package com.apm.coding_problems.remove_dups_sorted_list;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]
 */

import com.apm._lib.ListNode;

import java.net.SocketOption;

public class RemoveDups_RetainOne {

  public static void main(String[] args) {
    ListNode rootWithDups = new ListNode(1);
    rootWithDups.addNext(1).addNext(2).addNext(3).addNext(3);
    System.out.println("List with dups is: " + rootWithDups);
    remove_dups(rootWithDups);
    System.out.println("Modified list is: " + rootWithDups);

    ListNode rootNoDups = new ListNode(100);
    rootNoDups.addNext(200).addNext(300).addNext(400).addNext(500);
    System.out.println("List with no dups is: " + rootNoDups);
    remove_dups(rootNoDups);
    System.out.println("Modified List is: " + rootNoDups);
  }

  private static void remove_dups(ListNode root) {
    if (root == null) return;

    ListNode current = root.next, firstNonDup = root;
    while (current != null) {
      if (current.val != firstNonDup.val) {
        firstNonDup.next = current;
        firstNonDup = current;
      }

      current = current.next;
    }

    firstNonDup.next = null;
  }
}
