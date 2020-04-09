package com.kcore.juc;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample {

	static class MuCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			log.info("wating....");
			Thread.sleep(5000);
			return "yes";
		}
	}

	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTask = new FutureTask<>(new MuCallable());
		ExecutorService   executorService = Executors.newCachedThreadPool();
		new Thread(futureTask).start();
		log.info("start!");
		Thread.sleep(1000);
		String result = futureTask.get();
		log.info("result:{}", result);
		executorService.shutdown();
	}
}
