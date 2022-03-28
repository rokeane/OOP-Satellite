public class Battery {

  private double solarPanel;
  private boolean batteryOn;

  /**
   * Battery constructor
   */
  public Battery() {
    this.solarPanel = 0;
    this.batteryOn = true;
  }

  /**
   * @returns solar panel state
   */
  public double getsolarPanel() {
    return this.solarPanel;
  }

  /**
   * @returns battery state
   */
  public boolean getBatteryOn() {
    return this.batteryOn;
  }

  /**
   * @returns solar panel state
   */
  public void setsolarPanel(double solarPanel) {
    this.solarPanel = solarPanel;
  }

  /*
   * Battery functions depending on whether the solar panels are in use a periodic
   * sine function is used to simulate the cycles during which the solar panels
   * are in contact with solar radiation.
   */
  public void setBatteryOn(double time) {
    this.solarPanel = Math.sin(2 * Math.PI * time / 360);
    if (this.solarPanel > 0) {
      // Solar panels are producing electricity
      this.batteryOn = true;
    } else {
      // Solar panels are NOT producing electricity
      this.batteryOn = false;
    }
  }

}
