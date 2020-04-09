package com.kcore.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cyclicbarrierexplem {

	private static Logger Log =LoggerFactory.getLogger(Cyclicbarrierexplem.class);

	/**
	 * 	指定需要等待的线程数 ，当等待的线程数等于指定的线程数后，继续执行41 cyclicBarrier.wait();后面的代码
	 */
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			Thread.sleep(1000);

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
		cyclicBarrier.await();
		Log.info("{} is continue", threadNum);

	}
}
