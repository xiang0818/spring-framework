package demo.app.domain;

import org.springframework.stereotype.Component;

@Component
public class Properries {



	public int a;


	public int b;



	Properries(){}

	Properries(int b){
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
