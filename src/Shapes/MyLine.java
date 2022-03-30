package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.util.Vector;
import Interface.DrawPanel;

public class MyLine implements Drawable {
  public double startX;
  public double startY;
  public double endX;
  public double endY;
  public int thickness;
  public Color color;
  public DrawPanel dp;
  public boolean isSelected = Boolean.valueOf(false);
  public Vector<MyLine> v = new Vector<MyLine>();
  public Stroke stroke;

  public MyLine() {}

  public MyLine(double startX, double startY, double endX, double endY, int thickness, Color color,
      DrawPanel dp) {
    this.dp = dp;
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.thickness = thickness;
    this.color = color;
  }

  @Override
  public void draw(Graphics2D g, DrawPanel dp) {
    Line2D l = new Line2D.Double(startX, startY, endX, endY);
    g.setStroke(new BasicStroke(thickness));
    g.setColor(color);
    g.fill(l);
    g.draw(l);
    if (isSelected) {
      float dash[] = {5.0f, 5.0f};
      Stroke dotted =
          new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.5f, dash, 0.0F);
      double minX = Math.min(getStartX(), getEndX());
      double maxX = Math.max(getStartX(), getEndX());
      double minY = Math.min(getStartY(), getEndY());
      double maxY = Math.max(getStartY(), getEndY());
      int height = (int) (maxY - minY);
      int width = (int) (maxX - minX);
      g.setColor(Color.GRAY);
      g.setStroke(dotted);
      g.drawRect((int) (minX - getThickness() / 2 - 5), (int) (minY - getThickness() / 2 - 5),
          width + getThickness() + 10, height + getThickness() + 10);
    }
  }

  @Override
  public boolean contains(int x, int y) {
    if (x >= startX && x <= endX && y >= startY && y <= endY)
      return true;
    else
      return false;
  }

  @Override
  public double getEndX() {
    return this.endX;
  }

  @Override
  public double getEndY() {
    return this.endY;
  }

  @Override
  public void setEndX(double x) {
    this.endX = x;
  }

  @Override
  public void setEndY(double y) {
    this.endY = y;
  }

  @Override
  public void setX(int x) {}

  @Override
  public void setY(int y) {}

  @Override
  public double getStartX() {
    return this.startX;
  }

  @Override
  public double getStartY() {
    return this.startY;
  }

  @Override
  public double getX() {
    return 0;
  }

  @Override
  public double getY() {
    return 0;
  }

  @Override
  public void setStartX(double x) {
    this.startX = x;
  }

  @Override
  public void setStartY(double y) {
    this.startY = y;
  }

  @Override
  public void setSelected(Boolean valueOf) {
    this.isSelected = valueOf;
  }

  @Override
  public boolean isSelected() {
    if (isSelected = Boolean.valueOf(true))
      return true;
    return false;
  }

  @Override
  public int getThickness() {
    return this.thickness;
  }

  @Override
  public void setFillColor(Color color) {
    this.color = color;
    dp.repaint();
  }

  @Override
  public void setBorderColor(Color color) {}

  @Override
  public void setThickness(int t) {
    this.thickness = t;
    dp.repaint();
  }

  @Override
  public void setFontSize(int fontSize) {}

  public void addStraightLine(MyLine fl) {
    this.v.add(fl);
  }

  @Override
  public double getBeginX() {
    return this.startX;
  }

  @Override
  public double getBeginY() {
    return this.startY;
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setText(String newText) {
    // TODO Auto-generated method stub

  }
}
