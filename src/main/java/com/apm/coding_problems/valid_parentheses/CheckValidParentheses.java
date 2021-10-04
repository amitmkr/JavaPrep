package com.apm.coding_problems.valid_parentheses;

import java.util.*;
import java.util.stream.Collectors;

public class CheckValidParentheses {

  static class ParenPair {
    char openingChar;
    char closingChar;
    String name;

    public ParenPair(String name,  char openingChar, char closingChar) {
      this.name = name;
      this.openingChar = openingChar;
      this.closingChar = closingChar;
    }

    @Override
    public String toString() {
      return "Pair of " + name + " " + openingChar + closingChar;
    }
  }

  public static void main(String[] args) {
    final List<ParenPair> SupportedPairs = Arrays.asList(
      new ParenPair("Parenthesis", '(', ')'),
      new ParenPair("Braces", '{', '}'),
      new ParenPair("Brackets", '[', ']')
    );

    checkValidity_OnlyBracketsInExpr(SupportedPairs, "()");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "(())");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "{[()]}");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "[]{}()");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "(]");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "([]){}");
    checkValidity_OnlyBracketsInExpr(SupportedPairs, "({[(]})");

    System.out.println("\nNow supporting any chars");
    checkValidity_AnyCharsInExpr(SupportedPairs, "()");
    checkValidity_AnyCharsInExpr(SupportedPairs, "((abcd))");
    checkValidity_AnyCharsInExpr(SupportedPairs, "{abcd[4*(22)]}");
    checkValidity_AnyCharsInExpr(SupportedPairs, "[a-b]{a+b}(a*b)");
    checkValidity_AnyCharsInExpr(SupportedPairs, "(a[400]){22}");
    checkValidity_AnyCharsInExpr(SupportedPairs, "(]");
    checkValidity_AnyCharsInExpr(SupportedPairs, "({[(]})");
    checkValidity_AnyCharsInExpr(SupportedPairs, "({a[(ab]b})");
  }

  private static boolean checkValidity_OnlyBracketsInExpr(List<ParenPair> supportedPairs, String expression) {
    Map<Character, Character> bracketMapping = new HashMap<>();
    supportedPairs.stream().forEach(pair -> bracketMapping.put(pair.closingChar, pair.openingChar));

    boolean isExpressionValid = true;

    Stack<Character> charStack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      // If this is a closing character, verify opening character is at the top of the stack
      // Else, push it onto the stack
      Character openingChar = bracketMapping.get(ch);
      if (openingChar == null) {
        charStack.push(ch);
      }
      else {
        if (!charStack.empty()) {
          Character topOfStack = charStack.pop();
          if (! topOfStack.equals(openingChar)) {
            isExpressionValid = false;
          }
        }
        else {
          isExpressionValid = false;
        }
      }
    }

    isExpressionValid = isExpressionValid && charStack.empty();

    System.out.println("Expression '" + expression + "' is " + (isExpressionValid ? "VALID" : "INVALID"));

    return isExpressionValid;
  }

  private static boolean checkValidity_AnyCharsInExpr(List<ParenPair> supportedPairs, String expression) {
    //Map<Character, Character> bracketMapping = new HashMap<>();
    //supportedPairs.stream().forEach(pair -> bracketMapping.put(pair.closingChar, pair.openingChar));

    Map<Character, Character> bracketMapping = supportedPairs.stream().collect(Collectors.toMap(x -> x.closingChar, y -> y.openingChar));
    Set<Character> supportedOpeningChars = supportedPairs.stream().map(x -> x.openingChar).collect(Collectors.toSet());

    boolean isExpressionValid = true;

    Stack<Character> charStack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      // If this is a closing character, verify opening character is at the top of the stack
      // Else, push it onto the stack
      Character openingChar = bracketMapping.get(ch);
      if (openingChar == null) {
        if (supportedOpeningChars.contains(ch)) {
          charStack.push(ch);
        }
      }
      else {
        if (!charStack.empty()) {
          Character topOfStack = charStack.pop();
          if (! topOfStack.equals(openingChar)) {
            isExpressionValid = false;
          }
        }
        else {
          isExpressionValid = false;
        }
      }
    }

    isExpressionValid = isExpressionValid && charStack.empty();

    System.out.println("Expression '" + expression + "' is " + (isExpressionValid ? "VALID" : "INVALID"));

    return isExpressionValid;
  }

}
