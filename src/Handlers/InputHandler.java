package Handlers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import Enumerators.Tools;
import Interface.ButtonPanel;
import Interface.ColorPanel;
import Interface.DrawPanel;
import Interface.Window;
import Shapes.Drawable;
import Shapes.MyImage;
import Shapes.MyText;

/**
 * This class converts every response from a button into an action.
 */
public class InputHandler
    implements ActionListener, MouseListener, MouseMotionListener, ChangeListener {
  public Tools tool = Tools.RECTANGLE;

  public int startX, endX, startY, endY;
  public int releasedX, releasedY;
  public int previousX, previousY;
  public int newStartX, newStartY, newEndX, newEndY;
  public int x, y;
  public int counter = 0;
  public int thickness;
  public int fontSize;

  private Drawable selectedShape;

  public DrawPanel dp;
  public ButtonPanel bp;
  public ColorPanel cp;

  public Color color;
  public Window window;
  public MyImage activeImage;
  public MyText text;

  public InputHandler(DrawPanel dp, ButtonPanel bp, Window window) {
    this.window = window;
    this.bp = bp;
    this.dp = dp;
    this.dp.addMouseListener(this);
    this.dp.addMouseMotionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd != null) {
      if (this.selectedShape != null)
        this.selectedShape.setSelected(Boolean.valueOf(false));
      dp.selectedShape = null;
    }
    switch (cmd) {
      case "Rectangle":
        tool = Tools.RECTANGLE;
        window.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        break;
      case "Ellipse":
        tool = Tools.ELLIPSE;
        dp.repaint();
        window.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        break;
      case "Line":
        tool = Tools.LINE;
        dp.repaint();
        window.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        break;
      case "Text":
        tool = Tools.TEXT;
        window.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        break;
      case "Image":
        tool = Tools.IMAGE;
        window.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        break;
      case "Select":
        tool = Tools.SELECT;
        window.setCursor(new Cursor(Cursor.HAND_CURSOR));
        break;
      case "Resize":
        tool = Tools.RESIZE;
        window.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        break;
      case "Delete":
        tool = Tools.DELETE;
        break;
      case "Clear":
        dp.clearScreen();
        break;
      case "Undo":
        dp.undo();
      default:
        break;
    }
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    endX = e.getX();
    endY = e.getY();
    switch (tool) {
      case RECTANGLE:
        if (counter % 2 == 0) {
          dp.addRectangle(startX, startY, endX, endY);
          counter++;
          break;
        }
        dp.removeShape();
        counter++;
        break;
      case ELLIPSE:
        if (counter % 2 == 0) {
          dp.addEllipse(startX, startY, endX, endY);
          counter++;
          break;
        }
        dp.removeShape();
        counter++;
        break;
      case LINE:
        if (counter % 2 == 0) {
          dp.addLine(startX, startY, endX, endY);
          counter++;
          break;
        }
        dp.removeShape();
        counter++;
        break;
      case RESIZE:
        this.releasedX = endX;
        this.releasedY = endY;
        this.selectedShape = this.dp.getSelectedShape();
        this.selectedShape.setEndX(this.releasedX + this.newEndX);
        this.selectedShape.setEndY(this.releasedY + this.newEndY);
        this.dp.repaint();
        break;
      case SELECT:
        this.releasedX = e.getX();
        this.releasedY = e.getY();
        this.selectedShape = this.dp.getSelectedShape();
        if (this.selectedShape != null) {
          this.selectedShape.setStartX(this.releasedX - this.newStartX);
          this.selectedShape.setStartY(this.releasedY - this.newStartY);
          this.selectedShape.setEndX(this.releasedX + this.newEndX);
          this.selectedShape.setEndY(this.releasedY + this.newEndY);
          this.selectedShape.setX(e.getX());
          this.selectedShape.setY(e.getY());
        }
        this.dp.repaint();
        break;
      case DELETE:
        dp.deleteShape(e.getX(), e.getY());
        break;
      default:
        break;
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    startX = e.getX();
    startY = e.getY();
    switch (tool) {
      case TEXT:
        if (e.getButton() == 1) {
          dp.addText(startX, startY);
        }
        break;
      case SELECT:
        this.dp.selectedShape = this.dp.getSelectedShape();
        if (this.dp.selectedShape != null) {
          if (this.dp.selectedShape.contains(startX, startY)) {
            if (this.dp.selectedShape.getClass() == MyText.class) {
              this.dp.selectShape(startX, startY);
              this.selectedShape = this.dp.getSelectedShape();
              if (this.selectedShape.contains(this.x, this.y)) {
                String text = JOptionPane.showInputDialog(dp, "Enter text:", "Text");
                if (text != null)
                  dp.getSelectedShape().setText(text);
                dp.repaint();
              }
            }
          }
        }
        break;
      default:
        break;
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    endX = e.getX();
    endY = e.getY();
    switch (tool) {
      case RECTANGLE:
        if (counter % 2 != 0)
          dp.shapesList.remove(dp.shapesList.size() - 1);
        dp.addRectangle(startX, startY, endX, endY);
        break;
      case ELLIPSE:
        if (counter % 2 != 0)
          dp.shapesList.remove(dp.shapesList.size() - 1);
        dp.addEllipse(startX, startY, endX, endY);
        break;
      case LINE:
        if (counter % 2 != 0)
          dp.shapesList.remove(dp.shapesList.size() - 1);
        dp.addLine(startX, startY, endX, endY);
        break;
      case TEXT:
        dp.fill = Color.BLACK;
        dp.addText(startX, startY);
        break;
      case DELETE:
        dp.deleteShape(startX, startY);
        break;
      default:
        break;
    }
    counter = 0;
  }

  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {
    startX = e.getX();
    startY = e.getY();
    switch (tool) {
      case SELECT:
        this.x = e.getX();
        this.y = e.getY();
        this.dp.selectShape(this.x, this.y);
        this.selectedShape = this.dp.getSelectedShape();
        if (this.selectedShape != null) {
          this.startX = (int) this.selectedShape.getBeginX();
          this.startY = (int) this.selectedShape.getBeginY();
          this.endX = (int) this.selectedShape.getEndX();
          this.endY = (int) this.selectedShape.getEndY();
          this.newStartX = (this.x - this.startX);
          this.newStartY = (this.y - this.startY);
          this.newEndX = (this.endX - this.x);
          this.newEndY = (this.endY - this.y);
        }
        break;
      case IMAGE:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter =
            new FileNameExtensionFilter("JPG & PNG images", new String[] {"jpg", "png"});
        fc.setFileFilter(filter);
        int returnValue = fc.showOpenDialog(null);
        if (returnValue == 0) {
          this.activeImage = new MyImage(fc.getSelectedFile().getAbsolutePath(), e.getX(), e.getY(),
              e.getX(), e.getY());
          this.dp.addShape(this.activeImage);
        }
        this.dp.repaint();
        break;
      case RESIZE:
        this.x = e.getX();
        this.y = e.getY();
        this.dp.selectShape(this.x, this.y);
        this.selectedShape = this.dp.getSelectedShape();
        this.endX = (int) this.selectedShape.getEndX();
        this.endY = (int) this.selectedShape.getEndY();
        this.newEndX = (this.endX - this.x);
        this.newEndY = (this.endY - this.y);
        break;
      default:
        break;
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}

  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider) e.getSource();
    dp.thickness = 5;
    if (dp.getSelectedShape() != null)
      dp.getSelectedShape().setThickness(source.getValue());
    if (!source.getValueIsAdjusting()) {
      this.thickness = source.getValue();
      dp.thickness = source.getValue();
    }
  }
}
