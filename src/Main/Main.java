package Main;

import java.io.IOException;
import javax.swing.SwingUtilities;
import Interface.Window;

public class Main {
  /**
   * Starts the Paint 4.0 drawing application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("[SYSTEM] Starting Paint 4.0 ...");
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        System.out.println("[SYSTEM] Starting GUI ...");
        try {
          new Window();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
