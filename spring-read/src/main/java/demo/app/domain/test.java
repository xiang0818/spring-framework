package demo.app.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class test {

	public int a;


	@Autowired
	AutoTest autoTest;

	test(){

		System.out.println(1);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
