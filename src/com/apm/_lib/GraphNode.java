package com.apm._lib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GraphNode<Data> {
  private Data data;
  private List<GraphNode> edges;

  public GraphNode(Data data) {
    this.data = data;
    edges = new ArrayList<>();
  }

  public Data data() {
    return data;
  }

  public Stream<GraphNode> edges() {
    return edges.stream();
  }

  public void addEdgeTo(GraphNode node) {
    edges.add(node);
  }

  public GraphNode getNodeFor(Data data) {
//    for (GraphNode node : edges) {
//      if (node.data.equals(data)) {
//        return node;
//      }
//    }
    return edges.stream().filter(e -> e.data.equals(data)).findFirst().orElse(null);
  }

  public boolean contains(Data data) {
    return edges.stream().anyMatch(e -> data.equals(e));
  }

  private String toBriefString() {
    return "(" + data + ")";
  }

  private String toStringWithIndent(int indent) {
    StringBuilder builder = new StringBuilder();
    builder.append(" ".repeat(indent));
    builder.append("Node(Data=");
    builder.append(data);
    builder.append(",[\n");
    //edges.forEach(x -> { builder.append(x.toBriefString()); builder.append(","); });
    edges.forEach(x -> { builder.append(x.toStringWithIndent(indent+2)); });
    builder.append(" ".repeat(indent));
    builder.append("])\n");
    return builder.toString();
  }

  @Override
  public String toString() {
    return toStringWithIndent(0);
  }

  public static void main(String[] args) {
    GraphNode<Integer> root = new GraphNode(0);

    root.addEdgeTo(new GraphNode(1));
    root.addEdgeTo(new GraphNode(2));
    root.addEdgeTo(new GraphNode(3));

    root.getNodeFor(1).addEdgeTo(new GraphNode(10));
    root.getNodeFor(1).addEdgeTo(new GraphNode(11));
    root.getNodeFor(1).addEdgeTo(new GraphNode(12));

    root.getNodeFor(1).getNodeFor(10).addEdgeTo(new GraphNode(100));
    root.getNodeFor(1).getNodeFor(10).addEdgeTo(new GraphNode(101));
    root.getNodeFor(1).getNodeFor(10).addEdgeTo(new GraphNode(102));

    root.getNodeFor(1).getNodeFor(11).addEdgeTo(new GraphNode(110));
    root.getNodeFor(1).getNodeFor(11).addEdgeTo(new GraphNode(111));
    root.getNodeFor(1).getNodeFor(11).addEdgeTo(new GraphNode(112));

    root.getNodeFor(1).getNodeFor(12).addEdgeTo(new GraphNode(120));
    root.getNodeFor(1).getNodeFor(12).addEdgeTo(new GraphNode(121));
    root.getNodeFor(1).getNodeFor(12).addEdgeTo(new GraphNode(122));

    System.out.println(root);
  }
}
