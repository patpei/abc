package demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.importnew.com/8542.html
 * 
 * 在上面的程序中，我们创建了包含5个工作线程的固定大小线程池。然后，我们向线程池提交10个任务。
 * 由于线程池的大小是5，因此首先会启动5个工作线程，其他任务将进行等待。
 * 一旦有任务结束，工作线程会从等待队列中挑选下一个任务并开始执行。
 * @author pps
 *
 */
public class SimpleThreadPool {
	public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
