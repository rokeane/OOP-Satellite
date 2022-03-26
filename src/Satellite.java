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
   * @returns current rocket coordinates
   */
  public Satellite() {
    this.gps = new GPS();
    this.satCtrl = new SatelliteCtrl();
    this.clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));
    this.camera = new Camera();
  }

  /**
   * @returns current rocket coordinates
   */
  public GPS getGPS() {
    return this.gps;
  }

  /**
   * @returns current rocket coordinates
   */
  public SatelliteCtrl getSatCtrl() {
    return this.satCtrl;
  }

  /**
   * @returns current rocket coordinates
   */
  public Clock getClock() {
    return this.clock;
  }

  /**
   * @returns current rocket coordinates
   */
  public Camera getCamera() {
    return this.camera;
  }
}
