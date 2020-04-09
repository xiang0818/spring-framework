package com.kcore.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

	private final static int threadCound = 200;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch countDownLatch = new CountDownLatch(threadCound);
		for (int i = 0; i < threadCound; i++) {
			final int threadNum = i;
			executorService.execute(()-> {
				try {
					test(threadNum);
				} catch (Exception e) {

				} finally {
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		System.out.println("Finish");
	}

	private static void test(int threadNum) throws InterruptedException {
		Thread.sleep(100);
		System.out.println(threadNum);
		Thread.sleep(100);
	}
}
