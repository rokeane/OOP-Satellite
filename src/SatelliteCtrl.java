import java.time.*;

public class SatelliteCtrl {

  private Image img;

  public SatelliteCtrl() {
    this.img = new Image();
  }

  public Image getImage() {
    return this.img;
  }

  /**
   * @returns the time on board the satellite
   */
  public void isOverIsae(GPS gps, GroundStation gnd, Camera camera, Clock clock) {
    if (gps.getLatitude() == gnd.getLatitude() && gps.getLongitude() == gnd.getLongitude()) {
      double[] coordinates = new double[] { gps.getLongitude(), gps.getLatitude() };
      System.out.println("Taking Picture");
      System.out.println("UTC :: " + clock.instant());
      this.img = camera.takeImage(clock.instant(), coordinates);
    } else {
      System.out.println("ISAE not acquired");
    }
  }

}
