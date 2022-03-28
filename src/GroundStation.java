import java.time.*;

public class GroundStation {

  private double longitude;
  private double latitude;

  /**
   * Default GroundStation constructor
   */
  public GroundStation() {
    this.longitude = 1.5;
    this.latitude = 43.5;
  }

  /**
   * Constructor that specifies the longitude and latitude of the ground station
   */
  public GroundStation(double longitude, double latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  /**
   * @returns ground station longitude
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * @returns ground station latitude
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * sets the longitude of the ground station
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * sets the latitude of the ground station
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @returns a boolean that indicates whether or not the image has been saved
   * or rejected
   */
  public boolean analyseImageDPI(Image img) {
    if (img.getImageDPI() > 300) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * launches the rocket by setting the state of the rocket
   */
  public void launch(Rocket rocket) {
    rocket.setState("FLIGHT");
  }

  /**
   * releases the rocket by setting its state
   */
  public void release(Rocket rocket) {
    rocket.setState("RELEASE");
  }

  /**
   * updates the rocket telemetry with time
   */
  public void updateTelemetry(Rocket rocket, double time) {
    rocket.computeMass(time);
    rocket.computeVelocity(rocket.getCurrentMass());
    rocket.computeAltitude(time, rocket.getVelocity());
  }
  
  /**
   * updates the satellite telemetry with time
   */
  public void updateTelemetrySat(Satellite satellite, double time) {
    satellite.getGPS().setLongitude(time);
    satellite.getGPS().setLatitude(time);
  }

}
