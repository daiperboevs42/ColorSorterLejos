import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class Stop implements Behavior {

	private RegulatedMotor bigMotor;
	private RegulatedMotor smallMotor;
	private boolean suppressed = false;
	
	public Stop(RegulatedMotor big, RegulatedMotor small) {
		this.bigMotor = big;
		this.smallMotor = small;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		bigMotor.stop();
		smallMotor.stop();
		Delay.msDelay(100);
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
