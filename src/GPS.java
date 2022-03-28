public class GPS {

  private double longitude;
  private double latitude;
  public final static double INCLINATION = 43.5;

  /*
   GPS calculates the satellites coordinates with respect to its
   position above Earth

   Inclination of 20 degrees would mean that the satellite would never reach ISAE
   Therefore, the inclination is set to 43.5 degrees

   We have a 90 min period

   ISAE coordinates : long = 1.4742547702385902 / lat = 43.56569930662392

   Satellite is assumed to begin over ISAE where the ground station is also located.
   Coordinates rounded to one decimal point
   */
  public GPS() {
    this.longitude = 1.5;
    this.latitude = 43.5;
  }

  public double getLongitude() {
    return this.longitude;
  }

  public double getLatitude() {
    return this.latitude;
  }

  /*
  Latitude is a cosine function with a period of 90 minutes
   */

  public void setLatitude(double time) {
    double num = (Math.round(10*(INCLINATION * Math.cos(2 * Math.PI * time / 90))));
    this.latitude = num/10;

  }

  /*
  Longitude is a linear function with a period of 90 minutes
   */

  public void setLongitude(double time) {
    double num = (Math.round( 10*((((180 + 1.5) + (time * 4)) % 360) - 180) ));
    this.longitude = num/10 ;
  }

}
