package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import Interface.DrawPanel;

public class MyText implements Drawable {
  public int x, y;
  public double startX;
  public double startY;
  public double endX;
  public double endY;
  public int textSize;
  public Color color;
  public Font textFont;
  public String text;
  public Boolean isSelected = Boolean.valueOf(false);
  public DrawPanel dp;

  public MyText(int x, int y, Color color, Font textFont, String text, int textSize, DrawPanel dp) {
    this.dp = dp;
    this.textSize = textSize;
    this.x = x;
    this.y = y;
    this.color = color;
    this.textFont = textFont;
    this.text = text;
  }

  @Override
  public void draw(Graphics2D g, DrawPanel dp) {
    Font newFont = new Font("Serif", Font.BOLD, textSize);
    g.setFont(newFont);
    g.setColor(color);
    g.drawString(this.text, x, y);
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
      g.drawRect((int) minX - getThickness() / 2 - 5, (int) minY - getThickness() / 2 - 5,
          (int) width + getThickness() + 10, (int) height + getThickness() + 10);
    }
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public double getStartX() {
    return this.x;
  }

  public double getStartY() {
    return this.y - getFontSize() / 1.5;
  }

  public double getEndX() {
    return this.x + getFontSize() / 1.5 * (this.text.length() * 1.08);
  }

  public double getEndY() {
    return this.y + getFontSize() % 10;
  }

  public boolean isSelected() {
    return this.isSelected.booleanValue();
  }

  public void setSelected(Boolean b) {
    this.isSelected = b;
  }

  public void setFillColor(Color f) {
    this.color = f;
    dp.repaint();
  }

  public int getThickness() {
    return 1;
  }

  public void setThickness(int t) {}

  public void setStartX(double x) {
    this.startX = x;
  }

  public void setStartY(double y) {
    this.startY = y;
  }

  public void setEndX(double xe) {
    this.endX = xe;
  }

  public void setEndY(double ye) {
    this.endY = ye;
  }

  public Font getFont() {
    return this.textFont;
  }

  @Override
  public boolean contains(int x, int y) {
    if (x >= startX && x <= endX && y >= startY && y <= endY) {
      return true;
    } else
      return false;
  }

  @Override
  public void setBorderColor(Color color) {}

  @Override
  public void setFontSize(int fontSize) {
    this.textSize = fontSize;
  }

  public int getFontSize() {
    return this.textSize;
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
    return this.text;
  }

  @Override
  public void setText(String newText) {
    this.text = newText;
  }
}
