
public class SharedVariables {

	private int currentPosition = 0;
	private int nextPosition = 0;
	private boolean go = false;
	private boolean stop = false;
	private static SharedVariables instance = null;
	
	private SharedVariables() {
		
	}
	
	public static SharedVariables GetInstance() {
		if(instance == null) {
			instance = new SharedVariables();
		}
		return instance;
	}
	public boolean GetStop() {
		return stop;
	}
	public void SetStop(boolean value) {
		stop = value;
	}
	public int GetNextPosition() {
		return nextPosition;
	}
	public void SetNextPosition(int value) {
		nextPosition = value;
	}
	public int GetCurrentPosition() {
		return currentPosition;
	}
	public void SetCurrentPosition(int value) {
		currentPosition = value;
	}
	public boolean GetGo() {
		return go;
	}
	public void SetGo(boolean value) {
		go = value;
	}
}
