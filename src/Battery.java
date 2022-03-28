public class Battery {

  /*
   * Battery functions depending on whether the solar panels are in use
   *
   * A periodic sine function is used to simulate the cycles during which the
   * solar panels are in contact with solar radiation.
   */

  private double solarPanel;
  private boolean batteryOn;

  public Battery() {
    this.solarPanel = 0;
    this.batteryOn = true;
  }

  public double getsolarPanel() {
    return this.solarPanel;
  }

  public boolean getBatteryOn() {
    return this.batteryOn;
  }

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
