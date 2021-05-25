
public class SharedVariables {

	private int currentPosition = 0;
	private boolean go = false;
	private static SharedVariables instance = null;
	
	private SharedVariables() {
		
	}
	
	public static SharedVariables GetInstance() {
		if(instance == null) {
			instance = new SharedVariables();
		}
		return instance;
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
