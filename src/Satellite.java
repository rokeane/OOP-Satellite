import java.time.*;;

public class Satellite {

  public static final double VELOCITY = 28000; // Km/h
  public static final int ORBITAL_PERIOD = 90; // minutes
  public static final int ORBIT_ALTITUDE = 750; // Km
  public static final int INCLINATION = 20; // Km

  private GPS gps;
  private SatelliteCtrl satCtrl;
  private Clock clock;
  private Camera camera;

  /**
   * Satellite constructor that instantiates the GPS, Ctrl, clock and camera
   */
  public Satellite() {
    this.gps = new GPS();
    this.satCtrl = new SatelliteCtrl();
    this.clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));
    this.camera = new Camera();
  }

  /**
   * @returns GPS object
   */
  public GPS getGPS() {
    return this.gps;
  }

  /**
   * @returns the satellite ctrl object
   */
  public SatelliteCtrl getSatCtrl() {
    return this.satCtrl;
  }

  /**
   * @returns the satellite clock
   */
  public Clock getClock() {
    return this.clock;
  }

  /**
   * @returns the camera object
   */
  public Camera getCamera() {
    return this.camera;
  }

  /**
   * sets GPS object
   */
  public void setGPS(GPS gps) {
    this.gps = gps;
  }

  /**
   * sets the satellite ctrl object
   */
  public void setSatCtrl(SatelliteCtrl satCtrl) {
    this.satCtrl = satCtrl;
  }

  /**
   * sets the satellite clock
   */
  public void setClock(Clock clock) {
    this.clock = clock;
  }

  /**
   * sets the camera object
   */
  public void setCamera(Camera cam) {
    this.camera = cam;
  }
}
