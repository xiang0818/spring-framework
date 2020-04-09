package com.kcore;

import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.nio.charset.Charset;

public class unzip {

	private static final int buffer = 2048;

	final static String  gbk = "gbk";

	private static int BUFFERSIZE = 2 << 10;

	public static void main(String[] args) throws Exception {

		File file = new File("D:\\Java interview");


		File[] files = file.listFiles();
		Charset.forName("GBK");
		for (File file1 : files) {
			ZipUtil.unzip(file1, new File("D:\\Java interview\\unzip"), Charset.forName("GBK"));
			System.out.println(file1.getName());
		}

	}


}
