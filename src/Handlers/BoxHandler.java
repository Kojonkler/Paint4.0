package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import Interface.ColorPanel;
import Interface.DrawPanel;
import Shapes.Drawable;

public class BoxHandler implements ActionListener {
  public DrawPanel dp;
  public ColorPanel cp;

  public BoxHandler(DrawPanel dp, ColorPanel cp) {
    this.dp = dp;
    this.cp = cp;
  }

  public void actionPerformed(ActionEvent e) {
    JComboBox<?> cb = (JComboBox<?>) e.getSource();
    String cmd = (String) cb.getSelectedItem();
    int fontSize = Integer.parseInt(cmd);
    Drawable shape = this.dp.getSelectedShape();
    if (shape != null) {
      dp.getSelectedShape().setFontSize(fontSize);
      dp.repaint();
    }
  }
}
