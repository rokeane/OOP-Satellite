import java.time.*;

public class Image {

  private int imageDPI;
  private Instant timeCode;
  private double[] coordinates;

  /**
   * Default image constructor
   */
  public Image() {
    this.imageDPI = 0;
    this.timeCode = null;
    this.coordinates = new double[] { 0.0, 0.0 };
  }

  /**
   * specific constructor of the image
   */
  public Image(int imageDPI, Instant timeCode, double[] coordinates) {
    this.imageDPI = imageDPI;
    this.timeCode = timeCode;
    this.coordinates = new double[] { coordinates[0], coordinates[1] };
  }

  /**
   * @returns returns the image DPI
   */
  public int getImageDPI() {
    return this.imageDPI;
  }

  /**
   * @returns returns the Image time code
   */
  public Instant getTimeCode() {
    return this.timeCode;
  }

  /**
   * @returns the coordinates array containing longitude and latitude
   */
  public double[] getCoordinates() {
    return this.coordinates;
  }

  /**
   * @returns sets the image DPI
   */
  public void setImageDPI(int imageDPI) {
    this.imageDPI = imageDPI;
  }

  /**
   * @returns set the image time code with the satellite clock
   */
  public void setTimeCode(Instant timeCode) {
    this.timeCode = timeCode;
  }

  /**
   * @returns attaches the coordinates to the image before sending
   * to ground station
   */
  public void setCoordinates(double[] coordinates) {
    this.coordinates[0] = coordinates[0];
    this.coordinates[1] = coordinates[1];

  }

}
