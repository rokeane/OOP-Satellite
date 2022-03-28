import java.time.*;

public class Camera {

  /**
   * @returns returns an image containing the DPI, time code and coordinates
   */
  public Image takeImage(Instant timeCode, double[] coordinates) {
    int imageDPI = (int) (Math.random() * (500 - 200) + 200);
    Image img = new Image(imageDPI, timeCode, coordinates);
    return img;
  }

}
