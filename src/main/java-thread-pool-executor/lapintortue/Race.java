package lapintortue;

import java.util.concurrent.Callable;

public class Race implements Callable<Integer> {
	public static final int max=10;
	private String name;
	private long time;
	private int step;
	private boolean flag=true;
	
	
public Race(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}





public void setFlag(boolean flag) {
	this.flag = flag;
}





public int getStep() {
	return step;
}


@Override
public Integer call() throws InterruptedException, TiredException  {
	while(flag){
		step++;
		if (step>max) throw new TiredException(step);
		Thread.sleep(time);
	}
	return step;
}
}
