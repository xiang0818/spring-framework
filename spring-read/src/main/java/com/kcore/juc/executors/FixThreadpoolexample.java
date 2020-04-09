package com.kcore.juc.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class FixThreadpoolexample {


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					log.info("task:{}", index);
				}
			});
		}
		executorService.shutdown();
	}
}
