import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.subsumption.*;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class DetectColor implements Behavior {
	
	private EV3ColorSensor sensor;
	private boolean suppressed = false;

	public DetectColor(EV3ColorSensor sens) {
		this.sensor = sens;
	}
	@Override
	public boolean takeControl() {
		boolean go = SharedVariables.GetInstance().GetGo();
		if(!go)
			return true;
		return false;
	}

	@Override
	public void action() {
		// Do the Sorting
		
					LCD.clear();

						switch (sensor.getColorID()) {
						case Color.BLUE:
							LCD.clear();
							LCD.drawString("Blue", 0, 4);
							SharedVariables.GetInstance().SetNextPosition(0);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.GREEN:
							LCD.clear();
							LCD.drawString("Green", 0, 4);
							SharedVariables.GetInstance().SetNextPosition(1);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.YELLOW:
							LCD.clear();
							LCD.drawString("Yellow", 0, 4);
							SharedVariables.GetInstance().SetNextPosition(2);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.RED:
							LCD.clear();
							LCD.drawString("AAAAAAAAAAAAAAAAAAAH", 0, 4);
							Sound.beepSequenceUp();
							SharedVariables.GetInstance().SetNextPosition(3);
							SharedVariables.GetInstance().SetGo(true);
							break;

						default:
							// Stack should be empty here
							// Back to start
							LCD.clear();
							LCD.drawString("Stack is empty", 0, 4);
							SharedVariables.GetInstance().SetNextPosition(0);
							SharedVariables.GetInstance().SetGo(true);
							SharedVariables.GetInstance().SetStop(true);
							break;
						}
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
