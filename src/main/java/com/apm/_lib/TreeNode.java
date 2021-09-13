package com.apm._lib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

  public TreeNode left;
  public TreeNode right;
  public int data;

  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  private void levelOrderTraversal_Recursive(List<TreeNode> nodes, StringBuilder stringBuilder,
                                             boolean hasNonNullNodes, boolean withNewLines) {
    if (nodes.size() == 0) {
      return;
    }

    List<TreeNode> childNodes = new ArrayList<>();
    boolean hasNonNullChildren = false;

    for (TreeNode node : nodes) {
      if (node == null) {
        if (hasNonNullNodes)
          stringBuilder.append("N ");
      }
      else {
        stringBuilder.append(node.data);
        stringBuilder.append(" ");

        childNodes.add(node.left);
        childNodes.add(node.right);

        hasNonNullChildren = hasNonNullChildren || (node.left != null || node.right != null);
      }
    }

    if (withNewLines)
      stringBuilder.append("\n");

    levelOrderTraversal_Recursive(childNodes, stringBuilder, hasNonNullChildren, withNewLines);
  }

  public String levelOrderTraversal(boolean withNewLines) {
    List<TreeNode> nodeList = new ArrayList<>();
    nodeList.add(this);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LevelOrder: ");

    if (withNewLines)
      stringBuilder.append("\n");

    levelOrderTraversal_Recursive(nodeList, stringBuilder, true, withNewLines);

    if (withNewLines)
      stringBuilder.append("\n--- DONE ---");

    return stringBuilder.toString();
  }

  private void inOrderTraversal_Recursive(TreeNode currentNode, StringBuilder stringBuilder) {
    if (currentNode != null) {
      inOrderTraversal_Recursive(currentNode.left, stringBuilder);
      stringBuilder.append(currentNode.data);
      stringBuilder.append(" ");
      inOrderTraversal_Recursive(currentNode.right, stringBuilder);
    }
  }

  public String inOrderTraversal() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("InOrder: ");

    inOrderTraversal_Recursive(this, stringBuilder);

    return stringBuilder.toString();
  }

  public static TreeNode fromLevelOrderTraversal(String levelOrderOutput) {
    String[] nodeValues = levelOrderOutput.split(" ");

    int pos = 0;

    TreeNode rootNode = null;
    Queue<TreeNode> nodes = new LinkedList<>();

    if (nodeValues.length > 0) {
      if (! nodeValues[pos].equals("N")) {
        rootNode = new TreeNode(Integer.valueOf(nodeValues[pos]));
        nodes.add(rootNode);
      }
    }

    pos++;

    while (pos < nodeValues.length) {
      String leftNodeValue = nodeValues[pos];
      String rightNodeValue = nodeValues[pos+1];

      TreeNode currentNode = nodes.remove();

      if (! leftNodeValue.equals("N")) {
        assert currentNode != null : "Non-null left child for null parent";
        currentNode.left = new TreeNode(Integer.valueOf(leftNodeValue));
        nodes.add(currentNode.left);
      }
      else {
        nodes.add(null);
      }

      if (! rightNodeValue.equals("N")) {
        assert currentNode != null : "Non-null right child for null parent";
        currentNode.right = new TreeNode(Integer.valueOf(rightNodeValue));
        nodes.add(currentNode.right);
      }
      else {
        nodes.add(null);
      }

      pos = pos + 2;
    }

    return rootNode;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Node(");
    builder.append(this.data);
    builder.append("/");
    builder.append(this.left == null ? "N/" : "Y/");
    builder.append(this.right == null ? "N" : "Y");
    builder.append(")");
    return builder.toString();
  }

  public static void main(String[] args) {

    {
      TreeNode rootExample1 = new TreeNode(1);

      rootExample1.left = new TreeNode(2);
      rootExample1.right = new TreeNode(3);

      rootExample1.left.left = new TreeNode(1);

      rootExample1.right.left = new TreeNode(4);
      rootExample1.right.right = new TreeNode(5);

      rootExample1.left.left.right = new TreeNode(100);

      System.out.println(rootExample1);

      System.out.println("Example 1 = " + rootExample1.levelOrderTraversal(false));
    }

    {
      String levelOrderOutput = "1 2 3 1 N 4 5 N 100 N N N N";

      TreeNode rootExample2 = TreeNode.fromLevelOrderTraversal(levelOrderOutput);

      System.out.println(rootExample2);

      System.out.println("Example 2 = " + rootExample2.levelOrderTraversal(true));
    }
  }
}
