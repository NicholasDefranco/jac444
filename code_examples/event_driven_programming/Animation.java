package EventDrievn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Animation extends JFrame {
  public Animation() {
    // Create a MovingMessagePanel for displaying a moving message
    this.setLayout(new GridLayout(2, 1));
    add(new MovingMessagePanel("message moving?", 1000));
    add(new MovingMessagePanel("JAC444S1Q", 500));
  }

  /** Main method */
  public static void main(String[] args) {
    Animation frame = new Animation();
    frame.setTitle("AnimationDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(280, 100);
    frame.setVisible(true);
  }

  // Inner class: Displaying a moving message
  static class MovingMessagePanel extends JPanel {
    private String message = "Welcome to Java";
    private int xCoordinate = 0;
    private int yCoordinate = 20;

    public MovingMessagePanel(String message1, int delay) {
      this.message = message1;

      // Create a timer
      Timer timer = new Timer(delay, new TimerListener());
      timer.start();
    }

    /** Paint message */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (xCoordinate > getWidth()) {
        xCoordinate = -20;
      }
      xCoordinate += 5;
      g.drawString(message, xCoordinate, yCoordinate);
    }

    class TimerListener implements ActionListener {
      /** Handle ActionEvent */
      public void actionPerformed(ActionEvent e) {
        repaint();
      }
    }
  }
}
