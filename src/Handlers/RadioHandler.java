package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Enumerators.ColorChoice;
import Interface.ColorPanel;
import Interface.DrawPanel;

public class RadioHandler implements ActionListener {
  public DrawPanel dp;
  public ColorPanel cp;

  public RadioHandler(DrawPanel dp, ColorPanel cp) {
    this.dp = dp;
    this.cp = cp;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    switch (cmd) {
      case "Fill":
        cp.choices = ColorChoice.FILL;
        break;
      case "Border":
        cp.choices = ColorChoice.BORDER;
        break;
      default:
        break;
    }
  }

}
