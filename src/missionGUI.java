import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class missionGUI implements ActionListener {
  private JLabel altLabel = new JLabel("Altitude (m):  0     ");
  private JLabel velocityLabel = new JLabel("Velocity (m/s):  0     ");
  private JLabel massLabel = new JLabel("Mass (Kg):  0     ");
  private JLabel phaseLabel = new JLabel("State:  IDLE     ");
  private JFrame frame = new JFrame();
  private boolean isLaunched;

  public missionGUI() {
    this.isLaunched = false;
    // the clickable button
    JButton button = new JButton("Launch the Big Booty Rocket");
    button.addActionListener(this);

    // the panel with the button and text
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(button);
    panel.add(altLabel);
    panel.add(velocityLabel);
    panel.add(massLabel);
    panel.add(phaseLabel);

    // set up the frame and display it
    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Big Booty Control Center");
    frame.pack();
    frame.setVisible(true);
  }

  // process the button clicks
  @Override
  public void actionPerformed(ActionEvent e) {
    this.setIsLaunched(true);
    phaseLabel.setText("State: FLIGHT");
  }

  public void updateRocketTelemetry(Rocket rocket) {
    if (rocket.getState() == "FLIGHT") {
      altLabel.setText("Altitude (m):  " + (int) rocket.getAltitude());
      velocityLabel.setText("Velocity (m/s):  " + (int) rocket.getVelocity());
      massLabel.setText("Mass (Kg):  " + (int) rocket.getCurrentMass());
    } else if (rocket.getState() == "RELEASE") {
      phaseLabel.setText("State: RELEASED SATELLITE");
      altLabel.setText("Altitude (m):  " + 750000);
      velocityLabel.setText("Velocity (m/s):  " + 7777);
    }
  }

  public boolean getIsLaunched() {
    return this.isLaunched;
  }

  public void setIsLaunched(boolean b) {
    this.isLaunched = b;
  }
}
