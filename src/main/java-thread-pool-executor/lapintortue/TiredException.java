package lapintortue;

public class TiredException extends Exception{
	
	private int steps;
public TiredException(int steps) {
	this.steps = steps;
	// TODO Auto-generated constructor stub
}

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "couru "+steps+" pas";
}
}
