public class Rocket {

  public final double INITIAL_MASS = 150000; // kg
  public final double EJECTION_RATE = 140; // kg × s−1
  public final double RELEASE_RATE = 7657.126; // m/s

  private double velocity;
  private double current_mass;
  private double altitude;
  private String state; // idle , flight , release

  /**
   * @returns current rocket coordinates
   */
  public Rocket() {
    this.velocity = 0.0;
    this.current_mass = INITIAL_MASS;
    this.altitude = 0.0;
    this.state = "IDLE";
  }

  /**
   * @returns current rocket coordinates
   */
  public double getVelocity() {
    return this.velocity;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getCurrentMass() {
    return this.current_mass;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getAltitude() {
    return this.altitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public String getState() {
    return this.state;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @returns current rocket coordinates
   */
  public void computeVelocity(double current_mass) {
    this.velocity = EJECTION_RATE * Math.log10(INITIAL_MASS / current_mass);
  }

  /**
   * @returns fuel left in rocket tank
   */
  public void computeMass(int time) {
    this.current_mass = INITIAL_MASS - EJECTION_RATE * time;
  }

  /**
   * @returns current altitude of the rocket
   */
  public void computeAltitude(int time, double velocity) {
    this.altitude = (double) velocity * time;
  }

}
