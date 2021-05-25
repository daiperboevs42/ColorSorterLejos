import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import lejos.hardware.Sound;



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
		boolean stop = SharedVariables.GetInstance().GetStop();
		boolean go = SharedVariables.GetInstance().GetGo();
		if(stop && !go)
			return true;
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
