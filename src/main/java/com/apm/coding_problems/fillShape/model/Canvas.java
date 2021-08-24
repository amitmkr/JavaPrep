package com.apm.coding_problems.fillShape.model;

public class Canvas {

  private int length;
  private int width;
  private char canvas[][];

  public Canvas(int length, int width) {
    this.length = length;
    this.width = width;

    canvas = new char[width][length];
  }

  public void drawSquare(Vertex startsAt, int length) {
    if (! startsAt.belongsToTopRightQuadrant()) {
      throw new RuntimeException("Square starts outside the canvas");
    }
    if ((startsAt.getxCoOrd() + length > this.length) || (startsAt.getyCoOrd() + length > this.length)) {
      throw new RuntimeException("Square is larger than the canvas");
    }

    for (int x=startsAt.getxCoOrd(), y=startsAt.getyCoOrd(); x<=startsAt.getxCoOrd() + length; x++) {
      canvas[x][y] = '.';
    }
    for (int x=startsAt.getxCoOrd(), y=startsAt.getyCoOrd() + length; x<=startsAt.getxCoOrd() + length; x++) {
      canvas[x][y] = '.';
    }
    for (int y=startsAt.getyCoOrd(), x=startsAt.getxCoOrd(); y<=startsAt.getyCoOrd() + length; y++) {
      canvas[x][y] = '.';
    }
    for (int y=startsAt.getyCoOrd(), x=startsAt.getxCoOrd() + length; y<=startsAt.getyCoOrd() + length; y++) {
      canvas[x][y] = '.';
    }
  }

  public void fillColor(Vertex point) {

    if (canvas[point.getxCoOrd()][point.getyCoOrd()] == '*') {
      return;
    }

    System.out.println("Pt:" + point.getxCoOrd() + "," + point.getyCoOrd());

    canvas[point.getxCoOrd()][point.getyCoOrd()] = '*';

    Vertex pointAbove = point.getPointAbove();
    if (isPointWithinCanvasEdge(pointAbove) && ! isPointOnShapeEdge(pointAbove)) {
      fillColor(pointAbove);
    }

    Vertex pointBelow = point.getPointBelow();
    if (isPointWithinCanvasEdge(pointBelow) && ! isPointOnShapeEdge(pointBelow)) {
      fillColor(pointBelow);
    }

    Vertex pointRight = point.getPointRight();
    if (isPointWithinCanvasEdge(pointRight) && ! isPointOnShapeEdge(pointRight)) {
      fillColor(pointRight);
    }

    Vertex pointLeft = point.getPointLeft();
    if (isPointWithinCanvasEdge(pointLeft) && ! isPointOnShapeEdge(pointLeft)) {
      fillColor(pointLeft);
    }
  }

  private boolean isPointWithinCanvasEdge(Vertex point) {
    return point.getxCoOrd() >= 0 &&
      point.getyCoOrd() >= 0 &&
      point.getxCoOrd() < width &&
      point.getyCoOrd() < length;
  }

  private boolean isPointOnShapeEdge(Vertex point) {
    return canvas[point.getxCoOrd()][point.getyCoOrd()] == '.';
  }

  public void printCanvas() {
    for (int i=0; i<width+2; i++) {
      System.out.print("-");
    }
    System.out.print("\n");

    for (int y=0; y<length; y++) {
      System.out.print("|");
      for (int x=0; x<width; x++) {
        System.out.print(canvas[x][y]);
      }
      System.out.println("|");
    }

    for (int i=0; i<width+2; i++) {
      System.out.print("-");
    }
    System.out.print("\n");
  }
}
