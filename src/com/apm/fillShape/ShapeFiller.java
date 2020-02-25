package com.apm.fillShape;

import com.apm.fillShape.model.Canvas;
import com.apm.fillShape.model.Vertex;

public class ShapeFiller {

  public static void main(String[] args) {

    Canvas canvas = new Canvas(20, 10);
    canvas.printCanvas();

    canvas.drawSquare(new Vertex(2,2), 4);
    canvas.printCanvas();

    canvas.fillColor(new Vertex(3,3));
    canvas.printCanvas();
  }
}
