import java.time.*;

public class Image {

  private int imageDPI;
  private Instant timeCode;
  private double[] coordinates;

  /**
   * @returns current rocket coordinates
   */
  public Image() {
    this.imageDPI = 0;
    this.timeCode = null;
    this.coordinates = new double[] { 0.0, 0.0 };
  }

  /**
   * @returns current rocket coordinates
   */
  public Image(int imageDPI, Instant timeCode, double[] coordinates) {
    this.imageDPI = imageDPI;
    this.timeCode = timeCode;
    this.coordinates = new double[] { coordinates[0], coordinates[1] };
  }

  /**
   * @returns current rocket coordinates
   */
  public int getImageDPI() {
    return this.imageDPI;
  }

  /**
   * @returns current rocket coordinates
   */
  public Instant getTimeCode() {
    return this.timeCode;
  }

  /**
   * @returns current rocket coordinates
   */
  public double[] getCoordinates() {
    return this.coordinates;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setImageDPI(int imageDPI) {
    this.imageDPI = imageDPI;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setTimeCode(Instant timeCode) {
    this.timeCode = timeCode;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setCoordinates(double[] coordinates) {
    this.coordinates[0] = coordinates[0];
    this.coordinates[1] = coordinates[1];

  }

}
