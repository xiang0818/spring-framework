package demo.app.domain;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class test implements BeanNameAware {

	public int a;


	@Autowired
	AutoTest autoTest;

	@Autowired
	Properries properries;

	test(){

		System.out.println(1);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(name);
	}
}
