package com.apm.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResilientStreamProcessing {

  static List<Integer> getDividends(List<Integer> divisors, int num) {

    Function<Integer, Integer> myLogic = divisor -> num / divisor;

    return
      divisors.stream()
        .map(myLogic)
        .collect(Collectors.toList());
  }

  static List<Integer> getDividendsWithOptional_NotParallelSafe(List<Integer> divisors, int num) {

    Function<Integer, Optional<Integer>> myLogic =
      divisor -> divisor == 0 ? Optional.empty() : Optional.of(num / divisor);

    List<Integer> result = new ArrayList<>();

    divisors.stream()
      .map(myLogic)
      .forEach(dividend -> dividend.ifPresent(result::add)); // this is not safe to run in Parallel

    return result;
  }

  static List<Integer> getDividendsWithOptional_ParallelSafe(List<Integer> divisors, int num) {

    Function<Integer, Optional<Integer>> myLogic =
      divisor -> divisor == 0 ? Optional.empty() : Optional.of(num / divisor);

    return divisors.stream()
            .map(myLogic)
            .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty)) // mapping the Optional to Stream enables us to use the Parallel safe Collectors framework
            .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> divisors = Arrays.asList(1, 2, 3, 4, 5, 0);
    int num = 100;

    try {
      System.out.println("TRY 1 - Without Optional");
      getDividends(divisors, num).forEach(System.out::println);
    }
    catch (Exception e) {
      System.out.println("Caught Exception - " + e.getMessage());
    }

    System.out.println("TRY 2 - With Optional");
    getDividendsWithOptional_NotParallelSafe(divisors, num).forEach(System.out::println);

    System.out.println("TRY 3 - With Optional, Parallel Safe");
    getDividendsWithOptional_ParallelSafe(divisors, num).forEach(System.out::println);
  }
}
