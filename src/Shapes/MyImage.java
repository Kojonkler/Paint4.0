package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import Interface.DrawPanel;

public class MyImage implements Drawable {
  public double startX;
  public double startY;
  public double endX;
  public double endY;
  public BufferedImage image;
  public String path;
  public Color color;
  public int counter = 0;
  public boolean isSelected = Boolean.valueOf(false);
  public DrawPanel dp;

  public MyImage(String path, double startX, double startY, double endX, double endY) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.path = path;
    try {
      this.image = ImageIO.read(new File(path));
      this.endX = (startX + this.image.getWidth(null));
      this.endY = (startY + this.image.getHeight(null));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void draw(Graphics2D g, DrawPanel dp) {
    double minX = Math.min(getBeginX(), getEndX());
    double maxX = Math.max(getBeginX(), getEndX());
    double minY = Math.min(getBeginY(), getEndY());
    double maxY = Math.max(getBeginY(), getEndY());
    int height = (int) (maxY - minY);
    int width = (int) (maxX - minX);

    if (isSelected) {
      float dash[] = {5.0f, 5.0f};
      Stroke dotted =
          new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.5f, dash, 0.0F);
      g.setColor(Color.GRAY);
      g.setStroke(dotted);
      g.drawRect((int) minX - getThickness() / 2 - 5, (int) minY - getThickness() / 2 - 5,
          width + getThickness() + 10, height + getThickness() + 10);
    }

    g.drawImage(image, (int) minX, (int) minY, width, height, dp);
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  }

  public void flipImage() {
    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
    tx.translate(-image.getWidth(null), 0);
    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    this.image = op.filter(image, null);
  }

  public double getX() {
    return 0;
  }

  public double getY() {
    return 0;
  }

  public double getBeginX() {
    return this.startX;
  }

  public double getBeginY() {
    return this.startY;
  }

  public double getEndX() {
    return this.endX;
  }

  public double getEndY() {
    return this.endY;
  }

  public int getThickness() {
    return 0;
  }

  public boolean isSelected() {
    return this.isSelected;
  }

  public void setSelected(Boolean b) {
    this.isSelected = b.booleanValue();
  }

  public void setColor(Color c) {

  }

  public void setFillColor(Color f) {

  }

  public void setThickness(int t) {

  }

  public void setBeginX(double x) {
    this.startX = x;
  }

  public void setBeginY(double y) {
    this.startY = y;
  }

  public void setEndX(double xe) {
    this.endX = xe;
  }

  public void setEndY(double ye) {
    this.endY = ye;
  }

  public void setX(int x) {}

  public void setY(int y) {}

  @Override
  public boolean contains(int x, int y) {
    if (x >= startX && x <= endX && y >= startY && y <= endY) {
      return true;
    } else
      return false;
  }

  @Override
  public void setBorderColor(Color color) {

  }

  @Override
  public double getStartX() {
    return this.startX;
  }

  @Override
  public double getStartY() {
    return this.startY;
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
  public void setFontSize(int fontSize) {

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
