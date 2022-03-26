import java.time.*;

public class Main {

  public static final double EARTH_RADIUS = 6400000; // meters
  public static final double G = 0.0000000000667428; // m3×kg−1×s−2
  public static final double EARTH_MASS = 5973600000000000000000000.0; // Kg

  public static void main(String args[]) {
    missionGUI gui = new missionGUI();
    Rocket rocket = new Rocket();
    Satellite satellite = new Satellite();
    GroundStation gndStation = new GroundStation();
    Clock clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));

    long currentTime = clock.millis();
    long prevTime = clock.millis();

    double time = 0;

    while (rocket.getAltitude() < 750000) {
      currentTime = clock.millis();
      if (currentTime > prevTime + 10) {
        if (gui.getIsLaunched()) {
          gndStation.launch(rocket);
          time++;
          gui.updateRocketTelemetry(rocket);
          gndStation.updateTelemetry(rocket, time * 0.6);
        }
        prevTime = currentTime;
      }
    }
    gndStation.release(rocket);
    gui.updateRocketTelemetry(rocket);

    time = 0;
    while (true) {
      currentTime = clock.millis();
      if (currentTime > prevTime + 1000) {
        time++;
        if (time % 10 == 0) {
          satellite.getSatCtrl().isOverIsae(satellite.getGPS(), gndStation, satellite.getCamera(),
              satellite.getClock());
          if (gndStation.analyseImageDPI(satellite.getSatCtrl().getImage())) {
            System.out.println("saving Image");
          } else {
            System.out.println("rejecting Image");
          }
        }
        System.out.println(".");
        prevTime = currentTime;
      }
    }

  }
}
