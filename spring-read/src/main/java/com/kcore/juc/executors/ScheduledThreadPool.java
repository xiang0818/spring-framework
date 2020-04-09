package com.kcore.juc.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduledThreadPool {


	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool (2);

		executorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				log.info("runing");
			}
		}, 1, 2, TimeUnit.SECONDS);
	}
}
