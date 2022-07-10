package com.apm.coding_problems._comp_prog_halim;

import java.util.*;

/**
 * Suppose you are given an unsorted array S of n integers.
 * Solve each of the following tasks below with the best possible algorithms that you can think of and
 * analyze their time complexities.
 *
 * Let’s assume the following constraints: 1 ≤ n ≤ 100K so that O(n2) solutions are theoretically
 * infeasible in a contest environment.
 *
 * 1. Determine if S contains one or more pairs of duplicate integers.
 *
 */

public class E_2_2_1_1_DupIntegers {

    public static void main(String[] args) {
        final long MAX_NUMBERS = 1_000_000;

        int[] input = new Random().ints(1, 1_000_000).limit(MAX_NUMBERS).toArray();

        //Arrays.stream(input).forEach(num -> System.out.print(num+","));

        System.out.println("Finding dups brute force ...");
        long startBruteForce = System.currentTimeMillis();
        int dupsBruteForce =  find_dups_brute_force(input);
        long endBruteForce = System.currentTimeMillis();
        long timeBruteForce = endBruteForce - startBruteForce;

        Arrays.sort(input);

        System.out.println("Finding dups optimized ...");
        long startOptimized = System.currentTimeMillis();
        long dupsOptimized = find_dups_optimized(input);
        long endOptimized = System.currentTimeMillis();
        long timeOptimized = endOptimized - startOptimized;

        System.out.println("Finding dups optimized, O(1) space ...");
        long startOptimizedNoSpace = System.currentTimeMillis();
        long dupsOptimizedNoSpace = find_dups_optimized(input);
        long endOptimizedNoSpace = System.currentTimeMillis();
        long timeOptimizedNoSpace = endOptimizedNoSpace - startOptimizedNoSpace;


        System.out.println("Dups. BruteForce=" + dupsBruteForce
                            + " Optimized=" + dupsOptimized
                            + " Optimized, O(1) space=" + dupsOptimizedNoSpace);
        System.out.println("Time in millis. BruteForce=" + timeBruteForce
                            + " Optimized=" + timeOptimized
                            + " Optimized, O(1) space=" + timeOptimizedNoSpace);

    }

    private static int find_dups_optimized_o1_space(int[] input) {
        Arrays.sort(input);

        int numDups = 0;
        int lastDup = -1;

        int prevNum = input[0];
        for (int i=1; i<input.length; i++) {
            if (input[i] == prevNum) {
                if (lastDup != prevNum) {
                    numDups++;
                    lastDup = prevNum;
                }
            }

            prevNum = input[i];
        }

        return numDups;
    }

    private static int find_dups_optimized(int[] input) {
        Set<Integer> dups = new HashSet<>();

        Arrays.sort(input);

        int prevNum = input[0];
        for (int i=1; i<input.length; i++) {
            if (input[i] == prevNum) {
                dups.add(input[i]);
            }

            prevNum = input[i];
        }

        return dups.size();
    }

    private static int find_dups_brute_force(int[] input) {
        Set<Integer> dups = new HashSet<>();

        for (int i=0; i<input.length-1; i++) {
            for (int j=i+1; j<input.length; j++) {
                if (input[i] == input[j]) {
                    dups.add(input[i]);
                    break;
                }
            }
        }

        return dups.size();
    }
}
