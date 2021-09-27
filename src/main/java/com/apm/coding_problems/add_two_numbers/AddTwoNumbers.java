package com.apm.coding_problems.add_two_numbers;

/*
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

import com.apm._lib.ListNode;

public class AddTwoNumbers {

  public static void main(String[] args) {
    addNumbersAsList(342, 465);

    addNumbersAsList(9999999, 9999);

    addNumbersAsList(999, 999);

    addNumbersAsList(0, 200);

    addNumbersAsList(300, 0);

    addNumbersAsList(0, 0);

    addNumbersAsList("500", "00000000");
  }

  private static long addNumbersAsList(long num1, long num2) {
    ListNode num1AsList = ListNode.ofNumber(num1);
    ListNode num2AsList = ListNode.ofNumber(num2);
    ListNode sumAsList = add_Numbers(num1AsList, num2AsList);
    long sum = sumAsList.getReverseNumber();

    System.out.println();
    System.out.println("Number 1 as list is: " + num1AsList);
    System.out.println("Number 2 as list is: " + num2AsList);
    System.out.println("Answer as list is: " + sumAsList);
    System.out.println(num1 + " + " + num2 + " = " + sum);

    return sum;
  }

  private static long addNumbersAsList(String num1AsString, String num2AsString) {
    ListNode num1AsList = ListNode.ofNumber(num1AsString);
    ListNode num2AsList = ListNode.ofNumber(num2AsString);
    ListNode sumAsList = add_Numbers(num1AsList, num2AsList);
    long sum = sumAsList.getReverseNumber();

    System.out.println();
    System.out.println("Number 1 as list is: " + num1AsList);
    System.out.println("Number 2 as list is: " + num2AsList);
    System.out.println("Answer as list is: " + sumAsList);
    System.out.println(num1AsString + " + " + num2AsString + " = " + sum);

    return sum;
  }

  private static ListNode add_Numbers(ListNode example1_num1, ListNode example1_num2) {
    ListNode answer = new ListNode(0);
    ListNode current = answer;

    ListNode num1Ptr = example1_num1, num2Ptr = example1_num2;
    long carry = 0;
    while (num1Ptr != null && num2Ptr != null) {
      long sum = num1Ptr.val + num2Ptr.val + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      current = current.next;

      num1Ptr = num1Ptr.next;
      num2Ptr = num2Ptr.next;
    }

    ListNode remainingNumber = num1Ptr != null ? num1Ptr : (num2Ptr != null ? num2Ptr : null);
    while (remainingNumber != null) {
      long sum = carry + remainingNumber.val;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      current = current.next;
      remainingNumber = remainingNumber.next;
    }

    if (carry != 0) {
      current.next = new ListNode(carry);
    }

    return answer.next;
  }
}
