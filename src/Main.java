import java.time.*;

public class Main {

  public static final double EARTH_RADIUS = 6400000; // meters
  public static final double G = 0.0000000000667428; // m3×kg−1×s−2
  public static final double EARTH_MASS = 5973600000000000000000000.0; // Kg
  public static final double VELOCITY = 28000; // Km/h
  public static final int ORBITAL_PERIOD = 90; // minutes
  public static final int ORBIT_ALTITUDE = 750; // Km
  public static final int INCLINATION = 20; // Km

  public static int time = 0;

  public static void main(String args[]) {

    Rocket rocket = new Rocket();
    Satellite satellite = new Satellite();
    GroundStation gndStation = new GroundStation();

    Clock clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));

    long currentTime = clock.millis();
    long prevTime = clock.millis();

    gndStation.launch(rocket);
    System.out.println(rocket.getState());

    while (rocket.getAltitude() < 750) {
      currentTime = clock.millis();
      if (currentTime > prevTime + 100) {
        time++;

        gndStation.launch(rocket);
        gndStation.updateTelemetry(rocket, time);

        // System.out.println(time);
        prevTime = currentTime;
      }
    }
    gndStation.release(rocket);
    System.out.println(rocket.getState());

  }
}
