import java.time.*;;

public class Satellite {

  private GPS gps;
  private SatelliteCtrl satCtrl;
  private Clock clock;

  public Satellite() {
    this.gps = new GPS();
    this.satCtrl = new SatelliteCtrl();
    this.clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));
  }

}
