package com.kcore.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {

	private int start;
	private int end;


	public  static final   int theadold = 2;

	public ForkJoinExample(int start, int end) {
		this.start = start;
		this.end = end;

	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= theadold;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) /2;
			//拆分任务
			ForkJoinExample left = new ForkJoinExample(start, middle);
			ForkJoinExample right = new ForkJoinExample(middle + 1, end);
			//执行子任务
			left.fork();
			right.fork();

			int leftResult = left.join();
			int rightResult = right.join();
			sum = leftResult + rightResult;

		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinExample task = new ForkJoinExample(1, 100);
		Future<Integer> submit = forkJoinPool.submit(task);
		try {
			log.info("result:{}", submit.get());
		} catch (InterruptedException e) {
			log.error("InterruptedException error:{}", e);
		} catch (ExecutionException e) {
			log.error(" ExecutionException error:{}", e);
		}

	}
}
