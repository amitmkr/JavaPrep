package com.apm.coding_problems.check_binary_tree_balanced;

import com.apm._lib.TreeNode;

public class CheckBinaryTreeBalanced {

  public static void main(String[] args) {
    TreeNode balancedTree1 =
      TreeNode.fromLevelOrderTraversal("1 2 3 4 N");
    checkIfTreeIsBalanced(balancedTree1);

    TreeNode unBalancedTree1 =
      TreeNode.fromLevelOrderTraversal("1 2 3 4 N N N 5 N N N N N N N");
    checkIfTreeIsBalanced(unBalancedTree1);
  }

  private static void checkIfTreeIsBalanced(TreeNode root) {
    boolean balanced = internal_checkIfTreeIsBalanced(root).isNodeBalanced;
    System.out.println("Below tree " + (balanced ? "is " : " is NOT ") + "balanced");
    System.out.println(root.levelOrderTraversal(true));
  }

  private static class Result {
    boolean isNodeBalanced;
    int maxSubtreeHeight;

    public Result(boolean isNodeBalanced, int maxSubtreeHeight) {
      this.isNodeBalanced = isNodeBalanced;
      this.maxSubtreeHeight = maxSubtreeHeight;
    }
  }

  private static Result internal_checkIfTreeIsBalanced(TreeNode root) {
    if (root == null) {
      return new Result(true, 0);
    }

    Result leftResult =  internal_checkIfTreeIsBalanced(root.left);
    Result rightResult = internal_checkIfTreeIsBalanced(root.right);

    return new Result(Math.abs(leftResult.maxSubtreeHeight - rightResult.maxSubtreeHeight) <= 1,
      Math.max(leftResult.maxSubtreeHeight, rightResult.maxSubtreeHeight) + 1);
  }
}
