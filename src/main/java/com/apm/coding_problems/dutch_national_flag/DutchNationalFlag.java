package com.apm.coding_problems.dutch_national_flag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class DutchNationalFlag {

  public static enum Color { RED, WHITE, BLUE }

  private static void dnf_try1(List<Color> colors_pass1) {
    /*
    Copy into 3 sublists for each color and then combine.
    O(N) runtime, O(N) space
     */
    List<Color> red = new ArrayList<>();
    List<Color> white = new ArrayList<>();
    List<Color> blue = new ArrayList<>();

    for (Color color : colors_pass1) {
      assert color != null;
      assert color == Color.RED || color == Color.WHITE || color == Color.BLUE;

      switch (color) {
        case RED: red.add(color); break;
        case WHITE: white.add(color); break;
        case BLUE: blue.add(color); break;
      }
    }

    colors_pass1.clear();

    red.forEach(colors_pass1::add);
    white.forEach(colors_pass1::add);
    blue.forEach(colors_pass1::add);
  }

  private static void dnf_try2(List<Color> colors_pass2) {
    /*
    Make 2 passes.
    In the first, move smaller than pivot to the beginning.
    In the second, move larger than pivot to the end.
    O(N) time and O(1) space
     */

    Color pivot = Color.WHITE;

    // IMPORTANT
    // To compare enums with relative ordering, use ordinal()

    for (int i=0, smaller=0; i<colors_pass2.size(); i++) {
      if (colors_pass2.get(i).ordinal() < pivot.ordinal()) {
        System.out.println("SWAP: " + i + " <-> " + smaller);
        Collections.swap(colors_pass2, smaller, i);
        smaller++;
      }
    }
    System.out.println("DNF2. After 1st pass: " + colors_pass2);

    for (int j=colors_pass2.size()-1, larger= colors_pass2.size()-1; j>=0; j--) {
      if (colors_pass2.get(j).ordinal() > pivot.ordinal()) {
        System.out.println("SWAP: " + j + " <-> " + larger);
        Collections.swap(colors_pass2, larger, j);
        larger--;
      }
    }
    System.out.println("DNF2. After 2nd pass: " + colors_pass2);
  }

  private static void dnf_try3(List<Color> colors_try3) {
    // Make a single pass and try to move smaller and larger
    // O(N) time and O(1) space - O(N) with single pass

    Color pivot = Color.WHITE;

    for (int i=0, smaller=0, larger=colors_try3.size()-1;
         i < colors_try3.size() && i <= larger; ) {
      System.out.println("i="+i+" smaller="+smaller+" larger="+larger+" List:"+colors_try3);
      if (colors_try3.get(i).ordinal() < pivot.ordinal()) {
        System.out.println("SWAP: " + i + " <-> " + smaller);
        Collections.swap(colors_try3, i, smaller);
        smaller++;
        i++;
      }
      else if (colors_try3.get(i).ordinal() > pivot.ordinal()) {
        System.out.println("SWAP: " + i + " <-> " + larger);
        Collections.swap(colors_try3, i, larger);
        larger--;
      }
      else {
        i++;
      }
    }
  }

  public static void run_dnf_for(String comment, List<Color> colors) {
    System.out.println("\n---------------- " + comment);

    Collections.shuffle(colors);
    System.out.println("ORIG: " + colors);

    List<Color> colors_try1 = new ArrayList<>(colors);
    dnf_try1(colors_try1);
    System.out.println("Try 1: " + colors_try1);

    List<Color> colors_try2 = new ArrayList<>(colors);
    dnf_try2(colors_try2);
    System.out.println("Try 2: " + colors_try2);

    List<Color> colors_try3 = new ArrayList<>(colors);
    dnf_try3(colors_try3);
    System.out.println("Try 3: " + colors_try3);
  }

  public static void main(String[] args) {
    List<Color> colors_AllEqual = new ArrayList<>();
    IntStream.range(1,3).forEach(i -> colors_AllEqual.add(Color.RED));
    IntStream.range(1,3).forEach(i -> colors_AllEqual.add(Color.WHITE));
    IntStream.range(1,3).forEach(i -> colors_AllEqual.add(Color.BLUE));
    run_dnf_for("All colors equally spread", colors_AllEqual);

    List<Color> colors_MoreRed = new ArrayList<>();
    IntStream.range(1,8).forEach(i -> colors_MoreRed.add(Color.RED));
    IntStream.range(1,3).forEach(i -> colors_MoreRed.add(Color.WHITE));
    IntStream.range(1,3).forEach(i -> colors_MoreRed.add(Color.BLUE));
    run_dnf_for("More RED colors", colors_MoreRed);

    List<Color> colors_MoreWhite = new ArrayList<>();
    IntStream.range(1,3).forEach(i -> colors_MoreWhite.add(Color.RED));
    IntStream.range(1,8).forEach(i -> colors_MoreWhite.add(Color.WHITE));
    IntStream.range(1,3).forEach(i -> colors_MoreWhite.add(Color.BLUE));
    run_dnf_for("More WHITE colors", colors_MoreWhite);

    List<Color> colors_MoreBlue = new ArrayList<>();
    IntStream.range(1,3).forEach(i -> colors_MoreBlue.add(Color.RED));
    IntStream.range(1,3).forEach(i -> colors_MoreBlue.add(Color.WHITE));
    IntStream.range(1,8).forEach(i -> colors_MoreBlue.add(Color.BLUE));
    run_dnf_for("More BLUE colors", colors_MoreBlue);

  }

}
