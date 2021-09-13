package com.apm.coding_problems.common_ancestor;

/*
GayleLaakmann-4.8

First Common Ancestor

Find the first common ancestor of two nodes in a binary tree.
Avoid storing additional nodes in a data structure.
This is not necessarily a binary search tree.

 */

import com.apm._lib.TreeNode;

public class FirstCommonAncestor {

  public static void main(String[] args) {
    TreeNode root = TreeNode.fromLevelOrderTraversal("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
    System.out.println("TREE:");
    System.out.println(root.levelOrderTraversal(true));

    findCommonAncestor(root, 8, 12);
    findCommonAncestor(root, 8, 11);
    findCommonAncestor(root, 8, 8);
    findCommonAncestor(root, 8, 800);
    findCommonAncestor(root, 14, 15);
  }

  private static class Result {
    public boolean value1Found=false, value2Found=false;
    public boolean commonAncestorFound = false;
    public int commonAncestorValue = -1;

    public Result(boolean value1Found, boolean value2Found, boolean commonAncestorFound, int commonAncestorValue) {
      this.value1Found = value1Found;
      this.value2Found = value2Found;
      this.commonAncestorFound = commonAncestorFound;
      this.commonAncestorValue = commonAncestorValue;
    }
  }

  private static int findCommonAncestor(TreeNode root, int value1, int value2) {
    Result result = internal_findCommonAncestor(root, value1, value2);
    System.out.println("Common ancestor of " + value1 + " and " + value2 + " is " + result.commonAncestorValue);
    return result.commonAncestorValue;
  }

  private static Result internal_findCommonAncestor(TreeNode root, int value1, int value2) {
    if (root == null) {
      return new Result(false, false, false, -1);
    }

    Result leftResult = internal_findCommonAncestor(root.left, value1, value2);
    Result rightResult = internal_findCommonAncestor(root.right, value1, value2);

    if (leftResult.commonAncestorFound) return leftResult;
    if (rightResult.commonAncestorFound) return rightResult;

    if ( (leftResult.value1Found && rightResult.value2Found) ||
          (leftResult.value2Found && rightResult.value1Found) ) {
      return new Result(true, true, true, root.data);
    }
    else {
      return new Result(leftResult.value1Found || rightResult.value1Found || root.data == value1,
        leftResult.value2Found || rightResult.value2Found || root.data == value2,
        false, -1);
    }
  }
}
