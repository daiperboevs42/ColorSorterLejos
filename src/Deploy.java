import lejos.hardware.Sound;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class Deploy implements Behavior {
	private RegulatedMotor bigMotor;
	private RegulatedMotor smallMotor;
	private boolean suppressed = false;
	
	public Deploy(RegulatedMotor big, RegulatedMotor small) {
		this.bigMotor = big;
		this.smallMotor = small;
	}

	@Override
	public boolean takeControl() {
		boolean go = SharedVariables.GetInstance().GetGo();
		if(go) {
			return true;
			}
		return false;
	}

	@Override
	public void action() {
		driveTo(SharedVariables.GetInstance().GetNextPosition());
		popOut();
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}
	private void driveTo(int pos) {

		bigMotor.rotate(180 * (pos - SharedVariables.GetInstance().GetCurrentPosition()));
		Delay.msDelay(500);
		SharedVariables.GetInstance().SetCurrentPosition(pos);

	}

	private void popOut() {
		
		smallMotor.rotate(-180);
		Delay.msDelay(200);
		smallMotor.rotate(180);
		Delay.msDelay(100);

		// Shake the push-part back in place

		switch (SharedVariables.GetInstance().GetCurrentPosition()) {
		case 0:
			if(SharedVariables.GetInstance().GetStop()) {
				driveTo(0);
				Sound.beepSequence();
				SharedVariables.GetInstance().SetGo(false);
				break;
			}
			driveTo(1);
			SharedVariables.GetInstance().SetGo(false);
			break;
		case 3:
			driveTo(2);
			SharedVariables.GetInstance().SetGo(false);
			break;
		default:
			driveTo(SharedVariables.GetInstance().GetCurrentPosition() + 1);
			SharedVariables.GetInstance().SetGo(false);
			break;
		}

	}

}
