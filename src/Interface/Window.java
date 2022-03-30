package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame {
  /*
   * All the properties of the window.
   */
  public Window() throws IOException {
    super();

    /**
     * General information about the window properties.
     */
    setTitle("Paint 2.0 [Tom Kamp & Dennis den Hollander]");
    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setSize(new Dimension(1700, 920));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setIcon("Logo.jpg"); // This private void function sets the icon of the drawing application.

    /**
     * Initializing all classes needed to create the general window.
     */
    DrawPanel dp = new DrawPanel();
    JPanel bp = new ButtonPanel(dp, this);
    JPanel cp = new ColorPanel(dp);
    dp.setBackground(Color.WHITE);
    bp.setBackground(Color.LIGHT_GRAY);
    cp.setBackground(Color.LIGHT_GRAY);

    /**
     * Constructing the layout for the drawing program.
     */
    getContentPane().setLayout(new BorderLayout());
    getContentPane().setBackground(Color.BLACK);
    getContentPane().setVisible(true);
    getContentPane().add(dp, BorderLayout.CENTER);
    getContentPane().add(cp, BorderLayout.SOUTH);
    getContentPane().add(bp, BorderLayout.WEST);

    /**
     * This asks whether the user wants to see the tutorial and if so, start the tutorial.
     */
    int n = questionTutorial();
    if (n == 0)
      startTutorial();
  }

  /**
   * Sets the icon for the GUI.
   */
  private void setIcon(String fileName) {
    assert fileName != null : "No file selected.";
    try {
      setIconImage((Image) ImageIO.read(getClass().getResource("/resources/" + fileName)));
    } catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  /**
   * Asks wheter you want to start the tutorial.
   * 
   * @return n - Yes (1) No (0)
   */
  private int questionTutorial() {
    Object[] options = {"Yes", "No"};
    int n = JOptionPane.showOptionDialog(this, "Would you like to view the tutorial first?", "",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
    return n;
  }

  /**
   * Starts the tutorial using HTML in Java.
   */
  private void startTutorial() {
    JOptionPane optionPane = new JOptionPane(new JLabel(""
        + "<html><body><h3><font color = 'black'><center>Welcome to the tutorial!</h3>"
        + "<br>This tutorial will give a quick rundown of all the functions and how to use them.</center></font></body></html>"));
    JDialog dialog = optionPane.createDialog("Tutorial");
    dialog.setModal(true);
    dialog.setVisible(true);
    dialog.setLocationRelativeTo(this);

    JLabel label1 = new JLabel();
    File f1 = new File("Square.jpg");
    label1.setText("<html><img src=\"file:" + f1.toString() + "\">");

    JLabel label2 = new JLabel();
    File f2 = new File("Ellipse.jpg");
    label2.setText("<html><img src=\"file:" + f2.toString() + "\">");

    JLabel label3 = new JLabel();
    File f3 = new File("Line.jpg");
    label3.setText("<html><img src=\"file:" + f3.toString() + "\">");

    JOptionPane optionPane2 = new JOptionPane(new JLabel(""
        + "<html><h3><center>How to create and design shapes</center></h3>" + "<center>"
        + label1.getText() + label2.getText() + label3.getText() + "</center>"
        + "<h3><center>Creating shapes</center></h3>"
        + "<br><center>These buttons located on the left side of the screen are the default shapes (rectangle, ellipse and straight line)."
        + "<br>By clicking on one of them and holding down the mouse button while dragging over the drawing area, you create the selected shape.</center>"
        + "<h3><center>Designing shapes</center></h3>"
        + "<br><center>The slider named 'Line thickness' near the bottom left can be moved to change the thickness of the border or the thickness of a line."
        + "<br>At the bottom, there is an option to select either Fill or Border color, this is where you can set what part of the shape gets what color."
        + "<br>When having selected one of those options, you can select a color to allocate that color to the specified part of the shape."
        + "<br>On the far right, you see the currently selected colors.</center></html>"));
    JDialog dialog2 = optionPane2.createDialog("Tutorial");
    dialog2.setModal(true);
    dialog2.setVisible(true);
    dialog2.setLocationRelativeTo(this);

    JLabel label4 = new JLabel();
    File f4 = new File("Text.jpg");
    label4.setText("<html><img src=\"file:" + f4.toString() + "\">");

    JLabel label5 = new JLabel();
    File f5 = new File("Import.jpg");
    label5.setText("<html><img src=\"file:" + f5.toString() + "\">");

    JOptionPane optionPane3 = new JOptionPane(new JLabel(""
        + "<html><h3><center>Adding text and images</center></h3>" + "<center>" + label4.getText()
        + label5.getText() + "</center>"
        + "<br><center>By selecting on of these buttons, you can add text (left) or an image (right) at any place in the drawing area.</center>"
        + "<h3><center>Text</center></h3>"
        + "<br>In the bottom left corner, there is a drop menu called 'Font size', here you can select how big you want your text to be."
        + "<br>When clicking on the place where you want the text, a pop up appears, asking what you want as text."
        + "<br>After pressing 'OK', the text appears." + "<h3><center>Image</center></h3>"
        + "The import button allows you to import an image. "
        + "<br>Just as with the text, after clicking on a place in the drawing area, a pop up will show up where you can select an image. "
        + "<br>Find the desired picture and press 'Open'</html>"));
    JDialog dialog3 = optionPane3.createDialog("Tutorial");
    dialog3.setModal(true);
    dialog3.setVisible(true);
    dialog3.setLocationRelativeTo(this);

    JLabel label6 = new JLabel();
    File f6 = new File("Select.jpg");
    label6.setText("<html><img src=\"file:" + f6.toString() + "\">");

    JLabel label7 = new JLabel();
    File f7 = new File("Resize.jpg");
    label7.setText("<html><img src=\"file:" + f7.toString() + "\">");

    JOptionPane optionPane4 = new JOptionPane(new JLabel(""
        + "<html><h3><center>Selecting and resizing shapes</center></h3>" + "<center>"
        + label6.getText() + label7.getText() + "</center>"
        + "<br><center>The select button (left) and the resize button (right) allow you to change properties of a shape on the drawing grid.</center>"
        + "<h3><center>Select</center></h3>"
        + "<br>After having selected a shape, you can change the location of the shape by holding down the mouse button and dragging the shape to a new location. "
        + "<br>The border thickness can be changed by sliding it to a new thickness."
        + "<br>The color can be changed by once again selecting either Fill or Border color and clicking on the new color."
        + "<h3><center>Resize</center></h3>"
        + "<br>After clicking on this button, you can click on a shape and resize it by holding down the mouse button while dragging on the drawing area. "
        + "<br><font color = 'red'>Note that resizing always happens around the corner where the first mouse click was and that it is NOT neccesary to select a shape with the select button first!</font></html>"));
    JDialog dialog4 = optionPane4.createDialog("Tutorial");
    dialog4.setModal(true);
    dialog4.setVisible(true);
    dialog4.setLocationRelativeTo(this);

    JLabel label8 = new JLabel();
    File f8 = new File("Undo.jpg");
    label8.setText("<html><img src=\"file:" + f8.toString() + "\">");

    JLabel label9 = new JLabel();
    File f9 = new File("Delete.jpg");
    label9.setText("<html><img src=\"file:" + f9.toString() + "\">");

    JLabel label10 = new JLabel();
    File f10 = new File("Clear.jpg");
    label10.setText("<html><img src=\"file:" + f10.toString() + "\">");

    JOptionPane optionPane5 = new JOptionPane(new JLabel(""
        + "<html><h3><center>When you change your mind ...</center></h3>" + "<center>"
        + label8.getText() + label9.getText() + label10.getText() + "</center>"
        + "<br><center>In case you change your mind while using the program, there are several things you can do.</center>"
        + "<center>" + "<h3><center>Undo</center></h3>"
        + "<br>The circular arrow is the undo last shape button."
        + "<br>This button removes the last created shape every time you click on it"
        + "<h3><center>Delete</center></h3>" + "<br>The garbage can is the remove shape button."
        + "<br>After clicking on this button, you can click on any shape to remove it."
        + "<br><font color = 'red'>Note that it is NOT neccesary to select a shape with the select button first</font>"
        + "<h3><center>Clear screen</center></h3>"
        + "<br>The clear all button clears all the objects from the screen</center></html>"));
    JDialog dialog5 = optionPane5.createDialog("Tutorial");
    dialog5.setModal(true);
    dialog5.setVisible(true);
    dialog5.setLocationRelativeTo(this);
  }
}
