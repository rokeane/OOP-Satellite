public class Camera {

  /**
   * @returns current rocket coordinates
   */
  public Image takeImage(int timeCode, double[] coordinates) {
    int imageDPI = (int) Math.floor(6 * Math.random());
    Image img = new Image(imageDPI, timeCode, coordinates);
    return img;
  }

}
