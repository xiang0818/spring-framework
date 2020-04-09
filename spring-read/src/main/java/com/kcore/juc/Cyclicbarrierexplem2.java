package com.kcore.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class Cyclicbarrierexplem2 {

	private static Logger Log =LoggerFactory.getLogger(Cyclicbarrierexplem2.class);

	/**
	 * 	指定需要等待的线程数 ，当等待的线程数等于指定的线程数后，继续执行41 cyclicBarrier.wait();后面的代码
	 */
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
		Log.info("{}", "优先执行的代码!");
	});


	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			Thread.sleep(200);

			executorService.execute(()-> {
				try {
					test(threadNum);
				} catch (Exception e) {
					Log.error("{}", e.getMessage());
				}
			});
		}
		executorService.shutdown();
 	}

	private static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
		Thread.sleep(1000);
		Log.info("{} is ready", threadNum);
		try {
			//等待一定时间之后，如果没有达到要求的等待指数，那么不会继续等待，会继续执行后面代码
			cyclicBarrier.await(1000, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			Log.error("{}", e.getMessage());
		}
		Log.info("{} is continue", threadNum);

	}
}
