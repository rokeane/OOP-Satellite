import java.time.*;

public class GroundStation {

  private double longitude;
  private double latitude;

  /**
   * @returns current rocket coordinates
   */
  public GroundStation() {
    this.longitude = 0.0;
    this.latitude = 0.0;
  }

  /**
   * @returns current rocket coordinates
   */
  public GroundStation(double longitude, double latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public boolean analyseImageDPI(Image img) {
    if (img.getImageDPI() > 300) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @returns current rocket coordinates
   */
  public void launch(Rocket rocket) {
    rocket.setState("FLIGHT");
  }

  /**
   * @returns current rocket coordinates
   */
  public void release(Rocket rocket) {
    rocket.setState("RELEASE");
  }

  /**
   * @returns current rocket coordinates
   */
  public void updateTelemetry(Rocket rocket, double time) {
    rocket.computeMass(time);
    rocket.computeVelocity(rocket.getCurrentMass());
    rocket.computeAltitude(time, rocket.getVelocity());
  }

}
