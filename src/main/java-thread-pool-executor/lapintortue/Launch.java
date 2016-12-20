package lapintortue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Launch {
	public static void main(String[] args) {
		ExecutorService es= new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(1),//
				new ThreadPoolExecutor.DiscardOldestPolicy()){
			
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				super.afterExecute(r, t);
//				Future<Integer> f =(Future<Integer>) r;
//				try {
//					int step = f.get();
//				} catch (InterruptedException | ExecutionException e) {
//					System.out.println("in f.get");
//					e.printStackTrace();
//				}
				
				if(t!=null){
					if (t instanceof TiredException){
						System.out.println("fonctional exception");	
					}
				}
				
			}
			
		};
	//	ExecutorService es= Executors.newFixedThreadPool(2);
		
		Race lapin = new Race("lapin", 10);
		Race tortue = new Race("tortue", 20);
		Future<Integer> f1 = es.submit(lapin);
		Future<Integer> f2 = es.submit(tortue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lapin.setFlag(false);
		tortue.setFlag(false);
		try {
			int stepLapin = f1.get();
			int stepTortue = f2.get();
			System.out.println("lapin a couru "+stepLapin + " pas.");
			System.out.println("lapin a couru "+stepTortue + " pas.");
		}catch (InterruptedException | ExecutionException e) {
			if (e instanceof TiredException){
				System.out.println("fonctional exception");	
			}
			//e.get
			e.printStackTrace();
		}
		
		//es.shutdown();
		
	
}
}
