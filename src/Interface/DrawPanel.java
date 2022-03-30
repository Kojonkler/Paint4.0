package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Shapes.Drawable;
import Shapes.MyEllipse;
import Shapes.MyLine;
import Shapes.MyRectangle;
import Shapes.MyText;

public class DrawPanel extends JPanel {
  /**
   * All global variables needed for passing around between classes.
   */
  public MyEllipse e;
  public MyRectangle r;
  public MyLine l;
  public MyText t;
  public List<Drawable> shapesList = new ArrayList<Drawable>();
  public int thickness;
  public int counter = 0;
  public int fontSize = 12;
  public Color fill = Color.BLACK;
  public Color border = Color.WHITE;
  public Drawable selectedShape;
  final JFileChooser fc = new JFileChooser();

  /**
   * Initializes the paintComponent using the Graphics-class as an input.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Drawable s : shapesList) {
      s.draw(g2d, this);
    }
  }

  /**
   * Adds a rectangle to the drawing grid using four parameters.
   * 
   * @param x1 - Your starting X coordinate
   * @param y1 - Your starting Y coordinate
   * @param x2 - Your ending X coordinate
   * @param y2 - Your ending Y coordinate
   */
  public void addRectangle(int x1, int y1, int x2, int y2) {
    r = new MyRectangle(x1, y1, x2, y2, thickness, fill, border, this);
    shapesList.add(r);
    repaint();
  }

  /**
   * Adds an ellipse to the drawing grid using four parameters.
   * 
   * @param x1 - Your starting X coordinate
   * @param y1 - Your starting Y coordinate
   * @param x2 - Your ending X coordinate
   * @param y2 - Your ending Y coordinate
   */
  public void addEllipse(int x1, int y1, int x2, int y2) {
    e = new MyEllipse(x1, y1, x2, y2, thickness, fill, border, this);
    shapesList.add(e);
    repaint();
  }

  /**
   * Adds a straight line to the drawing grid using four parameters.
   * 
   * @param x1 - Your starting X coordinate
   * @param y1 - Your starting Y coordinate
   * @param x2 - Your ending X coordinate
   * @param y2 - Your ending Y coordinate
   */
  public void addLine(int x1, int y1, int x2, int y2) {
    l = new MyLine(x1, y1, x2, y2, thickness, fill, this);
    shapesList.add(l);
    repaint();
  }

  /**
   * Adds text to the grid using only two parameters. This function also includes the pop-up where
   * the program asks for what to convert to text.
   * 
   * @param x - Your starting X coordinate
   * @param y - Your starting Y coordinate
   */
  public void addText(int x, int y) {
    String text = JOptionPane.showInputDialog(this, "Enter text:", "Text");
    if (text != null) {
      Font font = new Font("Serif", Font.BOLD, fontSize);
      t = new MyText(x, y, fill, font, text, fontSize, this);
      shapesList.add(t);
      repaint();
    }
  }

  /**
   * Add a shape to the list of already made shapes.
   * 
   * @param shape
   */
  public void addShape(Drawable shape) {
    this.shapesList.add(shape);
  }

  /**
   * Removes the last shape from all shapes that have been made so far.
   */
  public void removeShape() {
    shapesList.remove(shapesList.size() - 1);
  }

  /**
   * Undo's the last made shape from the drawing grid.
   */
  public void undo() {
    assert shapesList.size() >= 0 : "No shapes left to undo.";
    removeShape();
    repaint();
  }

  /**
   * Clears the whole screen.
   */
  public void clearScreen() {
    shapesList.clear();
    counter = 0;
    repaint();
  }

  /**
   * When the mouse is located on a specific shape and the button delete is selected, delete that
   * shape.
   * 
   * @param x - x-coordinate of the mouse
   * @param y - y-coordinate of the mouse
   */
  public void deleteShape(int x, int y) {
    for (int i = shapesList.size() - 1; i >= 0; i--) {
      double minX = Math.min(((Drawable) this.shapesList.get(i)).getBeginX(),
          ((Drawable) this.shapesList.get(i)).getEndX());
      double maxX = Math.max(((Drawable) this.shapesList.get(i)).getBeginX(),
          ((Drawable) this.shapesList.get(i)).getEndX());
      double minY = Math.min(((Drawable) this.shapesList.get(i)).getBeginY(),
          ((Drawable) this.shapesList.get(i)).getEndY());
      double maxY = Math.max(((Drawable) this.shapesList.get(i)).getBeginY(),
          ((Drawable) this.shapesList.get(i)).getEndY());
      if ((x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY)) {
        shapesList.remove(i);
        break;
      }
    }
    repaint();
  }

  /**
   * Selects a shape when your mouse is on it and you double click it.
   * 
   * @param x - x-coordinate of the mouse
   * @param y - y-coordinate of the mouse
   */
  public void selectShape(int x, int y) {
    for (int i = this.shapesList.size() - 1; i >= 0; i--) {
      double minX = Math.min(((Drawable) this.shapesList.get(i)).getBeginX(),
          ((Drawable) this.shapesList.get(i)).getEndX());
      double maxX = Math.max(((Drawable) this.shapesList.get(i)).getBeginX(),
          ((Drawable) this.shapesList.get(i)).getEndX());
      double minY = Math.min(((Drawable) this.shapesList.get(i)).getBeginY(),
          ((Drawable) this.shapesList.get(i)).getEndY());
      double maxY = Math.max(((Drawable) this.shapesList.get(i)).getBeginY(),
          ((Drawable) this.shapesList.get(i)).getEndY());
      if ((x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY)) {
        ((Drawable) this.shapesList.get(i)).setSelected(Boolean.valueOf(true));
        for (int j = this.shapesList.size() - 1; j >= 0; j--) {
          if (!((Drawable) this.shapesList.get(j)).equals(this.shapesList.get(i))) {
            ((Drawable) this.shapesList.get(j)).setSelected(Boolean.valueOf(false));
          }
        }
        this.selectedShape = ((Drawable) this.shapesList.get(i));
        this.shapesList.remove(i);
        this.shapesList.add(this.selectedShape);
        repaint();
        break;
      }
    }
  }

  /**
   * Changes the text when double clicking on already existing text.
   * 
   * @param newText - What the old text is going to be changed to
   */
  public void changeText(String newText) {
    if (newText != null)
      this.selectedShape.setText(newText);
    repaint();
  }

  /**
   * Get the current selected shape.
   * 
   * @return selectedShape - the current selected shape
   */
  public Drawable getSelectedShape() {
    return this.selectedShape;
  }

  /**
   * Get's the text size of the current selected text-shape.
   * 
   * @param value
   */
  public void setTextSize(int value) {
    this.fontSize = value;
  }

  /**
   * Get the thickness of the selected shapeborder.
   * 
   * @return
   */
  public int getThickness() {
    return this.thickness;
  }

  /**
   * Get the current (fill)color of the shape.
   * 
   * @return Color fill
   */
  public Color getColor() {
    return this.fill;
  }
}
