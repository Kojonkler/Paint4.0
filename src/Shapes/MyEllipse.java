package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import Interface.DrawPanel;

public class MyEllipse implements Drawable {
  private double startX, startY, endX, endY;
  private int thickness;
  public Stroke stroke;
  public Color fill;
  public Color border;
  public DrawPanel dp;
  public boolean isSelected = Boolean.valueOf(false);

  public MyEllipse() {}

  public MyEllipse(double startX, double startY, double endX, double endY, int thickness,
      Color fill, Color border, DrawPanel dp) {
    this.dp = dp;
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.thickness = thickness;
    this.fill = fill;
    this.border = border;
  }

  @Override
  public void draw(Graphics2D g, DrawPanel dp) {
    double x = getStartX();
    double y = getStartY();
    double width = getWidth();
    double height = getHeight();
    Ellipse2D e = new Ellipse2D.Double(x, y, width, height);
    g.setStroke(new BasicStroke(thickness));
    g.setColor(fill);
    g.fill(e);
    g.setColor(border);
    g.draw(e);
    if (isSelected) {
      float dash[] = {5.0f, 5.0f};
      Stroke dotted =
          new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.5f, dash, 0.0F);
      g.setColor(Color.GRAY);
      g.setStroke(dotted);
      g.drawRect((int) getStartX() - getThickness() / 2 - 5,
          (int) getStartY() - getThickness() / 2 - 5, (int) width + getThickness() + 10,
          (int) height + getThickness() + 10);
    }
  }

  private double getWidth() {
    return Math.abs(startX - endX);
  }

  private double getHeight() {
    return Math.abs(startY - endY);
  }

  @Override
  public boolean contains(int x, int y) {
    if (x >= startX && x <= endX && y >= startY && y <= endY) {
      return true;
    } else
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
    return Math.min(startX, endX);
  }

  @Override
  public double getStartY() {
    return Math.min(startY, endY);
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
    this.fill = color;
    dp.repaint();
  }

  @Override
  public void setBorderColor(Color color) {
    this.border = color;
    dp.repaint();
  }

  @Override
  public void setThickness(int t) {
    this.thickness = t;
    dp.repaint();
  }

  @Override
  public void setFontSize(int fontSize) {}

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
