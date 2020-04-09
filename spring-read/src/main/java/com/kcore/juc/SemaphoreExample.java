package com.kcore.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	//总信号量
	private final static int semaphoreNum = 5;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(semaphoreNum);
		for (int i = 0; i < 20; i++) {
			final int threadNum = i;
			executorService.execute(()-> {
				try {
					semaphore.acquire(2); //获取信号量，获取到足够信号量才能执行，否则等待
					test(threadNum);
				} catch (InterruptedException e) {

				}
				semaphore.release(2);


			});
		}
 		System.out.println("Finish");
		executorService.shutdown();
	}

	private static void test(int threadNum) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(threadNum);
 	}
}
