package Interface;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Handlers.InputHandler;

public class ButtonPanel extends JPanel implements ChangeListener {
  public DrawPanel dp;
  public ColorPanel cp;
  public Window window;

  public JLabel label = new JLabel("Line thickness");
  public JSlider thickness = new JSlider(JSlider.VERTICAL, 0, 50, 1);

  public ButtonPanel(DrawPanel dp, Window window) throws IOException {
    super();
    this.dp = dp;
    this.window = window;
    InputHandler IH = new InputHandler(dp, this, window);

    ImageIcon rectanglePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Square.jpg")));
    ImageIcon ellipsePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Ellipse.jpg")));
    ImageIcon linePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Line.jpg")));
    ImageIcon textPic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Text.jpg")));
    ImageIcon imagePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Import.jpg")));
    ImageIcon resizePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Resize.jpg")));
    ImageIcon selectPic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Select.jpg")));
    ImageIcon undoPic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Undo.jpg")));
    ImageIcon deletePic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Delete.jpg")));
    ImageIcon clearPic =
        new ImageIcon((Image) ImageIO.read(getClass().getResource("/resources/Clear.jpg")));

    JButton rectangle = new JButton(rectanglePic);
    JButton ellipse = new JButton(ellipsePic);
    JButton line = new JButton(linePic);
    JButton text = new JButton(textPic);
    JButton image = new JButton(imagePic);
    JButton resize = new JButton(resizePic);
    JButton select = new JButton(selectPic);
    JButton undo = new JButton(undoPic);
    JButton delete = new JButton(deletePic);
    JButton clear = new JButton(clearPic);

    rectangle.setActionCommand("Rectangle");
    rectangle.setToolTipText("Draw a rectangle");
    rectangle.setBackground(Color.WHITE);
    rectangle.addActionListener(IH);

    ellipse.setActionCommand("Ellipse");
    ellipse.setToolTipText("Draw an ellipse");
    ellipse.setBackground(Color.WHITE);
    ellipse.addActionListener(IH);

    line.setActionCommand("Line");
    line.setToolTipText("Draw a straight line");
    line.setBackground(Color.WHITE);
    line.addActionListener(IH);

    text.setActionCommand("Text");
    text.setToolTipText("Insert some text");
    text.setBackground(Color.WHITE);
    text.addActionListener(IH);

    image.setActionCommand("Image");
    image.setToolTipText("Import an image onto the drawing grid");
    image.setBackground(Color.WHITE);
    image.addActionListener(IH);

    resize.setActionCommand("Resize");
    resize.setToolTipText("Resize the selected shape");
    resize.setBackground(Color.WHITE);
    resize.addActionListener(IH);

    select.setActionCommand("Select");
    select.setToolTipText("Select and move a shape");
    select.setBackground(Color.WHITE);
    select.addActionListener(IH);

    undo.setActionCommand("Undo");
    undo.setToolTipText("Undo one permutation");
    undo.setBackground(Color.WHITE);
    undo.addActionListener(IH);

    delete.setActionCommand("Delete");
    delete.setToolTipText("Delete a shape");
    delete.setBackground(Color.WHITE);
    delete.addActionListener(IH);

    clear.setActionCommand("Clear");
    clear.setToolTipText("Clear the whole drawing grid");
    clear.setBackground(Color.WHITE);
    clear.addActionListener(IH);

    thickness.setMinorTickSpacing(10);
    thickness.setMajorTickSpacing(10);
    thickness.setPaintTicks(true);
    thickness.setPaintLabels(true);
    thickness.setToolTipText("Changes the thickness of the line or shape");
    thickness.setBackground(Color.LIGHT_GRAY);
    thickness.addChangeListener(IH);

    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addGroup(layout.createSequentialGroup()
            .addComponent(rectangle, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ellipse, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(line, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(text, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(image, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(select, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(resize, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(undo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(delete, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clear, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thickness, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createParallelGroup()
            .addComponent(rectangle, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ellipse, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(line, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(text, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(image, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(select, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(resize, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(undo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(delete, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clear, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thickness, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
  }

  @Override
  public void stateChanged(ChangeEvent e) {

  }

}
