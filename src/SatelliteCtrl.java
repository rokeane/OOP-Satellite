public class SatelliteCtrl {

  private double time;
  private double longitude;
  private double latitude;

  /**
   * @returns coordinates of the satellite
   */
  public double[] getCoordinates() {

    double[] coordinates = { this.latitude, this.longitude };
    return coordinates;

  }

  /**
   * @returns the time on board the satellite
   */
  public double getTime() {
    return time;

  }
}
