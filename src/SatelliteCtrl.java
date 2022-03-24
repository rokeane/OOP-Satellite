import java.time.*;

public class SatelliteCtrl {

  /**
   * @returns the time on board the satellite
   */
  public String isOverIsae(GPS gps, GroundStation gnd, Camera camera, Clock clock) {
    if (gps.getLatitude() == gnd.getLatitude() && gps.getLongitude() == gnd.getLongitude()) {
      double[] coordinates = new double[] { gps.getLongitude(), gps.getLatitude() };
      camera.takeImage(clock.instant(), coordinates);
      return "Taking Picture";
    } else {
      return "ISAE not acquired";
    }
  }

}
