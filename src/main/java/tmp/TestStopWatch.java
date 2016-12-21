package tmp;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class TestStopWatch {

	@Test
	public void stopWatch() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		// Thread.sleep(1000);
		for (int i = 0; i < 1000; i++) {
			Thread.sleep(1);
		}
		stopWatch.stop();
		System.out.println(stopWatch.getTime());
		// System.out.println(sw.toString());
	}

}
