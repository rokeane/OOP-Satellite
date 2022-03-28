import java.time.*;

public class SatelliteCtrl {

  private Image img;

  /**
   * default ctrl constructor
   */
  public SatelliteCtrl() {
    this.img = new Image();
  }

  /**
   * @returns the image on board the satellite
   */
  public Image getImage() {
    return this.img;
  }

  /**
   * updates the GPS coordinates
   */
  public void updatePosition(GPS gps, double time) {
    gps.setLongitude(time);
    gps.setLatitude(time);
  }

  /**
   * verifies the coordinates of the gnd station and ISAE, if both match, the
   * camera will take an image
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
