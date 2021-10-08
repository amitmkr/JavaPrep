package com.apm.coding_problems.max_subarray;

/*
https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the
divide and conquer approach, which is more subtle.
 */

import java.util.Arrays;

public class MaxSubarray {

  public static void main(String[] args) {
    int[] data = { -2,1,-3,4,-1,2,1,-5,4 };

    ReturnVal retVal = find_max_subarry(data);
    System.out.println("Max sum is " + retVal.sum + " Start=" + retVal.startIndex + " End=" + retVal.endIndex
      + " Values are " + Arrays.toString(Arrays.copyOfRange(data, retVal.startIndex, retVal.endIndex + 1) ));
  }

  private static ReturnVal find_max_subarry(int[] data) {
    int startIndex = 0, endIndex = data.length - 1;

    int currentSumTotal = Arrays.stream(data).sum();

    ReturnVal returnVal = new ReturnVal(startIndex, startIndex, currentSumTotal);

    //System.out.println("Starting sum is " + currentSumTotal);

    while (startIndex != endIndex) {
      int sumDiscardLeft = currentSumTotal - data[startIndex];
      int sumDiscardRight = currentSumTotal - data[endIndex];
      int sumDiscardBothLeftRight = currentSumTotal - data[startIndex] - data[endIndex];

      int maxSum = Math.max(Math.max(Math.max(sumDiscardLeft, sumDiscardRight), sumDiscardBothLeftRight), returnVal.sum);

      if (maxSum == returnVal.sum) {
        // do nothing
      }
      else if (maxSum == sumDiscardLeft) {
        returnVal.sum = sumDiscardLeft;
        returnVal.startIndex = startIndex + 1;
      }
      else if (maxSum == sumDiscardRight) {
        returnVal.sum = sumDiscardRight;
        returnVal.endIndex = endIndex - 1;
      }
      else if (maxSum == sumDiscardBothLeftRight) {
        returnVal.sum = sumDiscardBothLeftRight;
        returnVal.startIndex = startIndex + 1;
        returnVal.endIndex = endIndex - 1;
      }

      startIndex++;
      endIndex--;
      currentSumTotal = sumDiscardBothLeftRight;
    }

    return returnVal;
  }

  static class ReturnVal {
    int startIndex;
    int endIndex;
    int sum;

    public ReturnVal(int startIndex, int endIndex, int sum) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
      this.sum = sum;
    }
  }
}
