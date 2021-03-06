import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class missionGUI implements ActionListener {
  private JLabel altLabel = new JLabel("Altitude (m):  0     ");
  private JLabel velocityLabel = new JLabel("Velocity (m/s):  0     ");
  private JLabel massLabel = new JLabel("Mass (kg):  150000     ");
  private JLabel phaseLabel = new JLabel("State:  IDLE     ");
  private JLabel latLabel = new JLabel("Lat:     ");
  private JLabel longLabel = new JLabel("Long:     ");
  private JLabel batteryLabel = new JLabel("Solar Panels:     ");
  private JLabel satLabel = new JLabel("Satellite Controller Log:");
  private JTextArea textArea = new JTextArea(10, 30);
  private JLabel gndLabel = new JLabel("Ground Station Log:");
  private JTextArea textAreaGnd = new JTextArea(10, 30);
  private JLabel timeLabel = new JLabel("Time (minutes):     ");
  private JFrame frame = new JFrame();

  private boolean isLaunched;
  private boolean isReleased;

  public missionGUI() {
    this.isLaunched = false;


    JButton button = new JButton("Launch the Big Rocket 🚀");
    button.addActionListener(this);

    JScrollPane areaScrollPane = new JScrollPane(textArea);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    JScrollPane areaScrollPaneGnd = new JScrollPane(textAreaGnd);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    altLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    velocityLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    massLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    phaseLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    batteryLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    latLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    longLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    satLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    gndLabel.setFont(new Font("Verdana", Font.BOLD, 15));
    timeLabel.setFont(new Font("Verdana", Font.PLAIN, 15));

    // the panel with the button and text
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); // top,left,bottom,right
    panel.setPreferredSize(new Dimension(500, 700));
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
    frame.setTitle("BB Control Center 🛰️");
    frame.pack();
    frame.setVisible(true);
  }

  // process the button click
  @Override
  public void actionPerformed(ActionEvent e) {
    if (this.isLaunched == false){
      this.setIsLaunched(true);
      phaseLabel.setText("State: FLIGHT");
    }

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

  // updates the satellite telemetry inside the GUI
  public void updateSatelliteTelemetry(Satellite satellite, Rocket rocket, double time) {
    if (rocket.getState() == "RELEASE") {
      longLabel.setText("Long: " + satellite.getGPS().getLongitude());
      latLabel.setText("Lat: " + satellite.getGPS().getLatitude());
      timeLabel.setText("Time (minutes): " + time);

    }
  }

  // returns the attribute
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
      batteryLabel.setForeground(Color.GREEN);
    } else {
      batteryLabel.setText("Solar Panels:  Deactivated");
      batteryLabel.setForeground(Color.RED);
    }
  }

  // sets the image attributes on the GUI
  public void imageCaptured(Satellite satellite, boolean b, Image image) {
    if (b == true){
      textArea.append("Capturing Image...");
      textArea.append("\nCoordinates: "+ satellite.getGPS().getLatitude() + "°N " + satellite.getGPS().getLongitude() + "°E" );
      textArea.append("\nDPI: "+ image.getImageDPI());
      textArea.append("\nTime Code: "+ image.getTimeCode());
      textArea.append("\nSending Image...\n\n");
    }
  }

  // Sets the image attributes on the ground station side
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
