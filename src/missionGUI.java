import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class missionGUI implements ActionListener {
  private JLabel altLabel = new JLabel("Altitude (m):  0     ");
  private JLabel velocityLabel = new JLabel("Velocity (m/s):  0     ");
  private JLabel massLabel = new JLabel("Mass (Kg):  0     ");
  private JLabel phaseLabel = new JLabel("State:  IDLE     ");
  private JLabel latLabel = new JLabel("Lat:     ");
  private JLabel longLabel = new JLabel("Long:     ");
  private JLabel batteryLabel = new JLabel("Solar Panels:     ");
  private JLabel satLabel = new JLabel("Satellite Controller Log:");
  private JTextArea textArea = new JTextArea(50, 50);
  private JLabel gndLabel = new JLabel("Ground Station Log:");
  private JTextArea textAreaGnd = new JTextArea(50, 50);
  private JLabel timeLabel = new JLabel("Time (minutes):     ");
  private JFrame frame = new JFrame();

  private boolean isLaunched;

  public missionGUI() {
    this.isLaunched = false;

    JButton button = new JButton("Launch the Big Booty Rocket");
    button.addActionListener(this);

    JScrollPane areaScrollPane = new JScrollPane(textArea);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    JScrollPane areaScrollPaneGnd = new JScrollPane(textAreaGnd);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    altLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    velocityLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    massLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    phaseLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    batteryLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    latLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    longLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    satLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    gndLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    timeLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

    // the panel with the button and text
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 100, 200));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(button);
    panel.add(altLabel);
    panel.add(velocityLabel);
    panel.add(massLabel);
    panel.add(phaseLabel);
    panel.add(latLabel);
    panel.add(longLabel);
    panel.add(batteryLabel);
    panel.add(satLabel);
    panel.add(areaScrollPane);
    panel.add(gndLabel);
    panel.add(areaScrollPaneGnd);
    panel.add(timeLabel);

    // set up the frame and display it
    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Big Booty Control Center");
    frame.pack();
    frame.setVisible(true);
  }

  // process the button click
  @Override
  public void actionPerformed(ActionEvent e) {
    this.setIsLaunched(true);
    phaseLabel.setText("State: FLIGHT");
  }

  // updates the rocket telemetry inside the GUI
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

<<<<<<< HEAD
  // updates the satellite telemetry inside the GUI
  public void updateSatelliteTelemetry(Satellite satellite, Rocket rocket) {
    if (rocket.getState() == "RELEASE") {
      longLabel.setText("Long: " + satellite.getGPS().getLongitude());
      latLabel.setText("Lat: " + satellite.getGPS().getLatitude());
    }
  }

  // returns the attribute
=======


  public void updateSatelliteTelemetry(Satellite satellite, Rocket rocket, double time) {

     if (rocket.getState() == "RELEASE") {

      longLabel.setText("Long: "+ satellite.getGPS().getLongitude());
      latLabel.setText("Lat: "+ satellite.getGPS().getLatitude());
      timeLabel.setText("Time (minutes): "+ time);

    }
  }

>>>>>>> 171debd600f812b1c1282f8f0aaf44c9ac41363e
  public boolean getIsLaunched() {
    return this.isLaunched;
  }

  // sets the attribute
  public void setIsLaunched(boolean b) {
    this.isLaunched = b;
  }

  // sets the battery state inside the GUI
  public void setIsBatteryON(Battery battery) {
    if (battery.getBatteryOn()) {
      batteryLabel.setText("Solar Panels:  Activated");
    } else {
      batteryLabel.setText("Solar Panels:  Deactivated");
    }
  }

  // sets the image attributes on the GUI
  public void imageCaptured(boolean b, Image image) {
    if (b == true) {
      textArea.append("Capturing Image...");
      textArea.append("\nDPI: " + image.getImageDPI());
      textArea.append("\nTime Code: " + image.getTimeCode());
      textArea.append("\nSending Image...\n\n");
    }
  }

<<<<<<< HEAD
  // Sets the image attributes on the ground station side
=======
>>>>>>> 171debd600f812b1c1282f8f0aaf44c9ac41363e
  public void imageReceived(boolean b, Image image) {
    textAreaGnd.append("Image Received\n");
    textAreaGnd.append("Time: " + image.getTimeCode());
    textAreaGnd.append("\nAnalysing Image...\n");
    if (b == true) {
      textAreaGnd.append("Image Saved\n\n");
    } else {
      textAreaGnd.append("Image Rejected\n\n");
    }
  }

}
