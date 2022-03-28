public class Rocket {

  public final double INITIAL_MASS = 150000; // Empty mass + Initial Fuel (kg)
  public final double EJECTION_RATE = 140; // kg × s−1
  public final double RELEASE_RATE = 7657.126; // m/s

  private double velocity;
  private double current_mass;
  private double altitude;
  private String state; // idle , flight , release

  public Rocket() {
    this.velocity = 0.0;
    this.current_mass = INITIAL_MASS;
    this.altitude = 0.0;
    this.state = "IDLE";
  }

  /*
   * returns current rocket velocity
   */
  public double getVelocity() {
    return this.velocity;
  }

  /*
   * returns current rocket mass
   */
  public double getCurrentMass() {
    return this.current_mass;
  }

  /*
   * returns current rocket altitude
   */
  public double getAltitude() {
    return this.altitude;
  }

  /*
   * returns current rocket State
   */
  public String getState() {
    return this.state;
  }

  /*
   * updates the current velocity of the rocket
   */
  public void setVelocity(double v) {
    this.velocity = v;
  }

  /*
   * sets rocket to its current mass
   */
  public void setMass(double m) {
    this.current_mass = m;
  }

  /*
   * updates the current rocket altitude
   */
  public void setAltitude(double alt) {
    this.altitude = alt;
  }

  /*
   * updates the current state of the rocket
   */
  public void setState(String state) {
    this.state = state;
  }

  /*
   * updates the current rocket velocity Computed as a function of release rate
   * andthe rocket mass
   */
  public void computeVelocity(double current_mass) {
    this.velocity = RELEASE_RATE * Math.log(INITIAL_MASS / current_mass);
  }

  /*
   * updates the fuel left in rocket tank based on the total mass
   */
  public void computeMass(double time) {
    this.current_mass = INITIAL_MASS - EJECTION_RATE * time;
  }

  /*
   * updates current altitude of the rocket
   */
  public void computeAltitude(double time, double velocity) {
    this.altitude = (double) velocity * time;
  }

}
