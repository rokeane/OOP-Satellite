public class GroundStation {

  private double[] coordinates;

  /**
   * @returns current rocket coordinates
   */
  public GroundStation() {
    this.coordinates = new double[] { 0.0, 0.0 };
  }

  /**
   * @returns current rocket coordinates
   */
  public GroundStation(double[] coordinates) {
    this.coordinates = new double[] { coordinates[0], coordinates[1] };
  }

  /**
   * @returns current rocket coordinates
   */
  public boolean analyseImageDPI(Image img) {
    this.coordinates = new double[] { 0.0, 0.0 };
    if (img.getgetImageDPI() > 300) {
      return true;
    } else {
      return false;
    }
  }

}
