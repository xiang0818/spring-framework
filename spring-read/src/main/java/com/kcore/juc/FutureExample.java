package com.kcore.juc;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureExample {

	static class MuCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			log.info("wating....");
			Thread.sleep(5000);
			return "yes";
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService   executorService = Executors.newCachedThreadPool();
		Future<String> future = executorService.submit(new MuCallable());
		log.info("start!");
		Thread.sleep(1000);
		String result = future.get();
		log.info("result:{}", result);
		executorService.shutdown();
	}
}
