public class Battery{

  private double daylight;
  private boolean batteryOn;

  public Battery() {
    this.daylight = 0;
    this.batteryOn = true;
  }

  public double getDaylight() {
    return this.daylight;
  }
  public boolean getBatteryOn() {
    return this.batteryOn;
  }

  public void setBatteryOn(double time) {

    this.daylight = Math.sin(2 * Math.PI * time/360);

    if(this.daylight>0){
      batteryOn = true;
    }else{
      batteryOn = false;
    }
  }

}
