import java.time.*;

// test comment

public class Main {

	// Gravitational constants
	public static final double EARTH_RADIUS = 6400000; // meters
	public static final double G = 0.0000000000667428; // m3×kg−1×s−2
	public static final double EARTH_MASS = 5973600000000000000000000.0; // Kg

	public static void main(String args[]) {
		// Initialization of new objects
		missionGUI gui = new missionGUI();
		Rocket rocket = new Rocket();
		Satellite satellite = new Satellite();
		GroundStation gndStation = new GroundStation();
		Clock clock = Clock.tick(Clock.systemUTC(), Duration.ofSeconds(0));
		Battery battery = new Battery();

		// variables to be used for simulation time
		long currentTime = clock.millis();
		long prevTime = clock.millis();
		double time = 0;

		// loop for the rocket launch. If button is pressed, the rocket will be launched
		// until the altitude of 750000m is reached. It will then be released
		while (rocket.getAltitude() < 750000) {
			currentTime = clock.millis();
			if (currentTime > prevTime + 10) {
				if (gui.getIsLaunched()) {
					gndStation.launch(rocket);
					time++;
					gui.updateRocketTelemetry(rocket);
					gndStation.updateTelemetryRocket(rocket, time * 0.6);
				}
				prevTime = currentTime;
			}
		}
		gndStation.release(rocket);
		gui.updateRocketTelemetry(rocket);

		// simulation time is reset to 0
		time = 0;

		// infinite loop for the satellite orbit around ISAE
		while (true) {
			currentTime = clock.millis();
			if (currentTime > prevTime + 1000) {
				time += 9;
				gndStation.updateTelemetrySat(satellite, time);
				gui.updateSatelliteTelemetry(satellite, rocket, time);
				battery.setBatteryOn(time);
				gui.setIsBatteryON(battery);

				satellite.getSatCtrl().updatePosition(satellite.getGPS(), time);
				System.out.println("Long:" + satellite.getGPS().getLongitude() + "Lat:" + satellite.getGPS().getLatitude());
				System.out.println("Time:" + time);

				// every 90 mins if the batteries are on, the satellite will capture an image if
				// it is over ISAE
				if (time % 90 == 0 && battery.getBatteryOn()) {
					satellite.getSatCtrl().isOverIsae(satellite.getGPS(), gndStation, satellite.getCamera(),
							satellite.getClock());
					gui.imageCaptured(true, satellite.getSatCtrl().getImage());
					gui.imageReceived(gndStation.analyseImageDPI(satellite.getSatCtrl().getImage()),
							satellite.getSatCtrl().getImage());

					// the ground station receives the image and analyzes the DPI
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
