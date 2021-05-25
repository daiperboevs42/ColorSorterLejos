import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.*;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.*;

public class DetectColor implements Behavior {
	
	private EV3ColorSensor sensor;
	private boolean suppressed = false;

	public DetectColor(EV3ColorSensor sens) {
		this.sensor = sens;
	}
	@Override
	public boolean takeControl() {
		if(!SharedVariables.GetInstance().GetGo())
			return true;
		return false;
	}

	@Override
	public void action() {
		// Do the Sorting
		
					LCD.clear();

					boolean stack_full = true;
					while (stack_full) {

						switch (sensor.getColorID()) {
						case Color.BLUE:
							LCD.clear();
							LCD.drawString("Blue", 0, 4);
							SharedVariables.GetInstance().SetCurrentPosition(0);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.GREEN:
							LCD.clear();
							LCD.drawString("Green", 0, 4);
							SharedVariables.GetInstance().SetCurrentPosition(1);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.YELLOW:
							LCD.clear();
							LCD.drawString("Yellow", 0, 4);
							SharedVariables.GetInstance().SetCurrentPosition(2);
							SharedVariables.GetInstance().SetGo(true);
							break;

						case Color.RED:
							LCD.clear();
							LCD.drawString("Red", 0, 4);
							SharedVariables.GetInstance().SetCurrentPosition(3);
							SharedVariables.GetInstance().SetGo(true);
							break;

						default:
							// Stack should be empty here
							// Back to start
							LCD.clear();
							LCD.drawString("Stack is empty", 0, 4);
							SharedVariables.GetInstance().SetCurrentPosition(0);
							SharedVariables.GetInstance().SetGo(true);
							stack_full = false;
							break;
						}
					}
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
