package com.apm.coding_problems.fillShape.model;

public class Vertex {

  private int xCoOrd;
  private int yCoOrd;

  public Vertex(int xCoOrd, int yCoOrd) {
    this.xCoOrd = xCoOrd;
    this.yCoOrd = yCoOrd;
  }

  public int getxCoOrd() {
    return xCoOrd;
  }

  public int getyCoOrd() {
    return yCoOrd;
  }

  public Vertex getPointAbove() {
    return new Vertex(xCoOrd, yCoOrd+1);
  }

  public Vertex getPointBelow() {
    return new Vertex(xCoOrd, yCoOrd-1);
  }

  public Vertex getPointRight() {
    return new Vertex(xCoOrd+1, yCoOrd);
  }

  public Vertex getPointLeft() {
    return new Vertex(xCoOrd-1, yCoOrd);
  }

  public boolean belongsToTopRightQuadrant() {
    return xCoOrd >= 0 && yCoOrd >= 0;
  }
}
