import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class MainBot {

	private static RegulatedMotor bigMotor;
	private static RegulatedMotor smallMotor;
	private static EV3ColorSensor sensor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brick brick = BrickFinder.getDefault();
		bigMotor = new EV3LargeRegulatedMotor(MotorPort.D);
		smallMotor = new EV3MediumRegulatedMotor(MotorPort.A);
		smallMotor.setSpeed(700);
		bigMotor.setSpeed(200);
		
		Port port = LocalEV3.get().getPort("S3");
		// Get an instance of the EV3 sensor
		sensor = new EV3ColorSensor(port);
		
		Behavior b1 = new DetectColor(sensor);
		Behavior b2 = new Deploy(bigMotor, smallMotor);
		Behavior b3 = new Stop(bigMotor, smallMotor);
		
		Behavior [] bArray = {b1, b2, b3};
		Arbitrator arby = new Arbitrator(bArray);
	      arby.go();
	}
}
