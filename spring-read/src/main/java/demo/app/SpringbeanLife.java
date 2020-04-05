package demo.app;

import demo.app.domain.AutoTest;
import demo.app.domain.test;
import demo.app.postprosecces.myPostprosecces;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringbeanLife {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext an = new
				AnnotationConfigApplicationContext(myPostprosecces.class, test.class, AutoTest.class);
	}
}
