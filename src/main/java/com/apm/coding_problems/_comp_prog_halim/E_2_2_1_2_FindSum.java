package com.apm.coding_problems._comp_prog_halim;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Suppose you are given an unsorted array S of n integers.
 * Solve each of the following tasks below with the best possible algorithms that you can think of and
 * analyze their time complexities.
 *
 * Let’s assume the following constraints: 1 ≤ n ≤ 100K so that O(n2) solutions are theoretically
 * infeasible in a contest environment.
 *
 * 2. Given an integer v,find two integers a,b ∈ S, such that a+b=v.
 * 3. Follow-up to Question 2: what if the given array S is already sorted?
 *
 */

public class E_2_2_1_2_FindSum {

  public static void main(String[] args) {
    final int MAX_NUMBERS = 1_000_000;

    int[] input = new Random().ints(1, MAX_NUMBERS).limit(MAX_NUMBERS).toArray();

    for (int rep=0; rep<20; rep++) {
      int v = new Random().nextInt(MAX_NUMBERS);

      int pos1 = find_sum(input, v);
    }
  }

  private static int find_sum(int[] input, int v) {
    Set<Integer> numsToFind = new HashSet<>();

    int i;
    for (i=0; i<input.length; i++) {
      if (numsToFind.contains(input[i])) {
        System.out.println("Found. " + input[i] + " at pos " + i);
        break;
      }
      numsToFind.add(v - input[i]);
    }
    return i;
  }
}
