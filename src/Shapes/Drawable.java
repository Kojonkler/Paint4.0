package Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import Interface.DrawPanel;

public interface Drawable {
  public void draw(Graphics2D g, DrawPanel dp);

  public boolean contains(int x, int y);

  public double getX();

  public double getY();

  public double getBeginX();

  public double getBeginY();

  public double getStartX();

  public double getStartY();

  public double getEndX();

  public double getEndY();

  public void setX(int x);

  public void setY(int y);

  public void setStartX(double x);

  public void setStartY(double y);

  public void setEndX(double x);

  public void setEndY(double y);

  public void setSelected(Boolean valueOf);

  public boolean isSelected();

  public int getThickness();

  public void setFillColor(Color color);

  public void setBorderColor(Color color);

  public void setThickness(int value);

  public void setFontSize(int fontSize);

  public String getText();

  public void setText(String newText);
}
