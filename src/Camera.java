import java.time.*;

public class Camera {

  /**
   * @returns current rocket coordinates
   */
  public Image takeImage(Instant timeCode, double[] coordinates) {
    int imageDPI = (int) (Math.random() * (500 - 200) + 200);
    Image img = new Image(imageDPI, timeCode, coordinates);
    return img;
  }

}
