package Interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Enumerators.ColorChoice;
import Enumerators.Tools;
import Handlers.BoxHandler;
import Handlers.RadioHandler;

public class ColorPanel extends JPanel implements ChangeListener, ActionListener {
  private static final long serialVersionUID = 1L;
  public Tools tool = Tools.SELECT;
  public DrawPanel dp;
  public ColorChoice choices = ColorChoice.FILL;
  JButton fill;
  JButton border;
  public boolean isSelected = Boolean.valueOf(false);

  public ColorPanel(DrawPanel dp) {
    this.dp = dp;

    BoxHandler bh = new BoxHandler(dp, this);
    RadioHandler rh = new RadioHandler(dp, this);

    String[] fontSize =
        {"12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72", "200"};

    JComboBox<String> sizes = new JComboBox<String>(fontSize);
    sizes.addActionListener(bh);
    JLabel sizePanel = new JLabel("Font size");

    JRadioButton fillColor = new JRadioButton("Fill color", true);
    fillColor.setBackground(Color.LIGHT_GRAY);
    fillColor.setActionCommand("Fill");
    fillColor.addActionListener(rh);

    JRadioButton borderColor = new JRadioButton("Border color", false);
    borderColor.setBackground(Color.LIGHT_GRAY);
    borderColor.setActionCommand("Border");
    borderColor.addActionListener(rh);

    Box verticalBox = Box.createVerticalBox();
    verticalBox.add(fillColor);
    verticalBox.add(borderColor);

    Box verticalBox2 = Box.createVerticalBox();
    verticalBox2.add(sizePanel);
    verticalBox2.add(sizes);

    ButtonGroup bg = new ButtonGroup();
    bg.add(fillColor);
    bg.add(borderColor);

    JButton black = new JButton();
    black.setActionCommand("BLACK");
    black.setBackground(Color.BLACK);
    black.setToolTipText("Black");
    black.addActionListener(this);

    JButton brown = new JButton();
    brown.setActionCommand("BROWN");
    brown.setBackground(new Color(60, 42, 26));
    brown.setToolTipText("Brown");
    brown.addActionListener(this);

    JButton gray = new JButton();
    gray.setActionCommand("GRAY");
    gray.setBackground(Color.LIGHT_GRAY);
    gray.setToolTipText("Gray");
    gray.addActionListener(this);

    JButton white = new JButton();
    white.setActionCommand("WHITE");
    white.setBackground(Color.WHITE);
    white.setToolTipText("White");
    white.addActionListener(this);

    JButton red = new JButton();
    red.setActionCommand("RED");
    red.setBackground(Color.RED);
    red.setToolTipText("Red");
    red.addActionListener(this);

    JButton green = new JButton();
    green.setActionCommand("GREEN");
    green.setBackground(Color.GREEN);
    green.setToolTipText("Green");
    green.addActionListener(this);

    JButton orange = new JButton();
    orange.setActionCommand("ORANGE");
    orange.setBackground(new Color(255, 140, 0));
    orange.setToolTipText("Orange");
    orange.addActionListener(this);

    JButton yellow = new JButton();
    yellow.setActionCommand("YELLOW");
    yellow.setBackground(Color.YELLOW);
    yellow.setToolTipText("Yellow");
    yellow.addActionListener(this);

    JButton blue = new JButton();
    blue.setActionCommand("BLUE");
    blue.setBackground(Color.BLUE);
    blue.setToolTipText("Blue");
    blue.addActionListener(this);

    JButton magenta = new JButton();
    magenta.setActionCommand("MAGENTA");
    magenta.setBackground(Color.MAGENTA);
    magenta.setToolTipText("Magenta");
    magenta.addActionListener(this);

    JButton cyan = new JButton();
    cyan.setActionCommand("CYAN");
    cyan.setBackground(Color.CYAN);
    cyan.setToolTipText("Cyan");
    cyan.addActionListener(this);

    JButton purple = new JButton();
    purple.setActionCommand("PURPLE");
    purple.setBackground(new Color(128, 0, 128));
    purple.setToolTipText("Purple");
    purple.addActionListener(this);

    JButton pink = new JButton();
    pink.setActionCommand("PINK");
    pink.setBackground(Color.PINK);
    pink.setToolTipText("Pink");
    pink.addActionListener(this);

    JButton transparent = new JButton();
    transparent.setActionCommand("TRANSPARENT");
    transparent.setOpaque(false);
    transparent.setContentAreaFilled(false);
    transparent.setToolTipText("Transparent");
    transparent.addActionListener(this);

    JButton fill = new JButton();
    this.fill = fill;
    fill.setActionCommand("FILL");
    fill.setBackground(Color.BLACK);
    fill.setToolTipText("Fill colour");
    fill.addActionListener(this);

    JButton border = new JButton();
    this.border = border;
    border.setActionCommand("BORDER");
    border.setBackground(Color.WHITE);
    border.setToolTipText("Border colour");
    border.addActionListener(this);

    JLabel fillLabel = new JLabel("Fill colour");
    JLabel borderLabel = new JLabel("Border colour");

    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addGroup(layout.createParallelGroup()
            .addComponent(verticalBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verticalBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(black, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(brown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gray, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(white, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(red, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(green, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(orange, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(yellow, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(blue, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cyan, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purple, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(magenta, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pink, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transparent, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup()
                .addComponent(fillLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fill, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borderLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(border, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(verticalBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verticalBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(black, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(brown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gray, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(white, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(red, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(green, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(orange, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(yellow, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(blue, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cyan, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purple, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(magenta, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pink, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transparent, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fillLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fill, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borderLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(border, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
  }

  @Override
  public void stateChanged(ChangeEvent e) {}

  @Override
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    switch (cmd) {
      case "BLACK":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.BLACK);
          fill.setBackground(Color.BLACK);
          dp.fill = Color.BLACK;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.BLACK);
          border.setBackground(Color.BLACK);
          dp.fill = Color.BLACK;
        }
        break;
      case "BROWN":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(new Color(60, 42, 26));
          fill.setBackground(new Color(60, 42, 26));
          dp.fill = new Color(60, 42, 26);
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(new Color(60, 42, 26));
          border.setBackground(new Color(60, 42, 26));
          dp.border = new Color(60, 42, 26);
        }
        break;
      case "GRAY":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.LIGHT_GRAY);
          fill.setBackground(Color.LIGHT_GRAY);
          dp.fill = Color.LIGHT_GRAY;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.LIGHT_GRAY);
          border.setBackground(Color.LIGHT_GRAY);
          dp.border = Color.LIGHT_GRAY;
        }
        break;
      case "WHITE":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.WHITE);
          fill.setBackground(Color.WHITE);
          dp.fill = Color.WHITE;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.WHITE);
          border.setBackground(Color.WHITE);
          dp.border = Color.WHITE;
        }
        break;
      case "RED":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.RED);
          fill.setBackground(Color.RED);
          dp.fill = Color.RED;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.RED);
          border.setBackground(Color.RED);
          dp.border = Color.RED;
        }
        break;
      case "GREEN":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.GREEN);
          fill.setBackground(Color.GREEN);
          dp.fill = Color.GREEN;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.GREEN);
          border.setBackground(Color.GREEN);
          dp.border = Color.GREEN;
        }
        break;
      case "YELLOW":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.YELLOW);
          fill.setBackground(Color.YELLOW);
          dp.fill = Color.YELLOW;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.YELLOW);
          border.setBackground(Color.YELLOW);
          dp.border = Color.YELLOW;
        }
        break;
      case "BLUE":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.BLUE);
          fill.setBackground(Color.BLUE);
          dp.fill = Color.BLUE;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.BLUE);
          border.setBackground(Color.BLUE);
          dp.border = Color.BLUE;
        }
        break;
      case "MAGENTA":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.MAGENTA);
          fill.setBackground(Color.MAGENTA);
          dp.fill = Color.MAGENTA;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.MAGENTA);
          border.setBackground(Color.MAGENTA);
          dp.border = Color.MAGENTA;
        }
        break;
      case "CYAN":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.CYAN);
          fill.setBackground(Color.CYAN);
          dp.fill = Color.CYAN;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.CYAN);
          border.setBackground(Color.CYAN);
          dp.border = Color.CYAN;
        }
        break;
      case "PURPLE":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(new Color(128, 0, 128));
          fill.setBackground(new Color(128, 0, 128));
          dp.fill = new Color(128, 0, 128);
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(new Color(128, 0, 128));
          border.setBackground(new Color(128, 0, 128));
          dp.border = new Color(128, 0, 128);
        }
        break;
      case "PINK":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(Color.PINK);
          fill.setBackground(Color.PINK);
          dp.fill = Color.PINK;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(Color.PINK);
          border.setBackground(Color.PINK);
          dp.border = Color.PINK;
        }
        break;
      case "ORANGE":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(new Color(255, 140, 0));
          fill.setBackground(Color.ORANGE);
          dp.fill = Color.ORANGE;
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(new Color(255, 140, 0));
          border.setBackground(Color.ORANGE);
          dp.border = Color.ORANGE;
        }
        break;
      case "TRANSPARENT":
        if (choices == ColorChoice.FILL) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setFillColor(new Color(1, 0, 0, 0f));
          fill.setBackground(new Color(1, 0, 0, 0f));
          dp.fill = new Color(1, 0, 0, 0f);
        } else if (choices == ColorChoice.BORDER) {
          if (dp.getSelectedShape() != null)
            dp.getSelectedShape().setBorderColor(new Color(1, 0, 0, 0f));
          border.setBackground(new Color(1, 0, 0, 0f));
          dp.border = new Color(1, 0, 0, 0f);
        }
        break;
      default:
        break;
    }
  }
}
