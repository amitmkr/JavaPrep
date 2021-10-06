package com.apm.coding_problems.min_window_substring;


/*
https://leetcode.com/problems/minimum-window-substring/

Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    String source = "ADOBECODEBANC";
    String toFind = "ABC";

    String minWindowSubstring = find_minimum_window_substring(source, toFind);

    System.out.println("Minimum window substring is: " + minWindowSubstring);
  }

  private static String find_minimum_window_substring(String source, String toFind) {
    int substringStart = 0, substringEnd = 0;
    int sourceLen = source.length(), toFindLen = toFind.length();

    Map<Character, Integer> toFindCounts = new HashMap<>();
    for (char ch : toFind.toCharArray()) {
      toFindCounts.put(ch, 0);
    }

    //System.out.println(toFindCounts);

    int matchedChars = 0;
    int windowStart = 0, windowEnd = 0;

    for (int i=0; i<sourceLen; i++) {
      System.out.println("Char: " + source.charAt(i));

      Integer count = toFindCounts.computeIfPresent(source.charAt(i), (ch, chCount) -> { return chCount + 1;} );
      if (count != null) {
        // Current char is part of toFind
        count = count + 1;
        matchedChars++;
        windowEnd = i;

        System.out.println(toFindCounts);
        System.out.println("Is part of toFind. NewCount=" + count + " MatchingChars=" + matchedChars);

        // all chars to find are matched
        // contract the beginning of the window
        while (matchedChars == toFindLen) {
          System.out.println("All chars matched, attempting compression, WindowStart=" + windowStart
            + " Substr=" + source.substring(windowStart, windowEnd+1));
          char ch = source.charAt(windowStart);
          Integer countForCompression = toFindCounts.get(ch);
          // if the char thrown out due to compression is part of toFind, decrease the count of that char
          // If the count reaches zero, we no longer have a matching toFind, and we stop the window compression.
          if (countForCompression != null) {
            countForCompression = countForCompression - 1;
            if (countForCompression == 0) {
              matchedChars--;
              System.out.println("All counts exhausted for char=" + ch + " WindowStart=" + windowStart);
              countForCompression = countForCompression + 1;
            }
            else {
              windowStart++;
              System.out.println("Interesting char (" + ch + ") removed, but count is still more than Zero. WindowStart=" + windowStart);
            }

            toFindCounts.put(ch, countForCompression);
          }
          else {
            windowStart++;
            System.out.println("Uninteresting char (" + ch + ") compressed. WindowStart=" + windowStart);
          }
        }
      }
    }

    System.out.println("WindowStart=" + windowStart + " WindowEnd=" + windowEnd);
    return source.substring(windowStart, windowEnd+1);
  }
}
