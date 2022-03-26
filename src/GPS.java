public class GPS {

  private double longitude;
  private double latitude;

  public final static int INCLINATION = 20;

  /**
   * @returns current rocket coordinates
   */
  public GPS() {
    this.longitude = 1.5;
    this.latitude = 43.5;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * @returns current rocket coordinates
   */
  public void setLatitude(int time) {
    this.latitude = INCLINATION * Math.cos(2 * Math.PI * time / 90);
  }

  /**
   * @returns current rocket coordinates
   */
  public void setLongitude(int time) {
    this.longitude = (((180 + 1.5) + (time * 4)) % 360) - 180;
  }

}

// we have a 90 min period
// 45*sin(2*pi*t/90)
// 180*sin(2*pi*t/90)
// ISAE coordinates : long = 1.4742547702385902 / lat = 43.56569930662392
