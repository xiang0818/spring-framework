package demo.app;


import demo.app.domain.factorybean.FactortbeanDemo;
import demo.app.domain.factorybean.demobyFactorybean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringbeanLife {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext an = new
				AnnotationConfigApplicationContext("demo.app.*");
//		demobyFactorybean factortbeanDemo = an.getBean("factortbeanDemo", demobyFactorybean.class);//获取代理的bean
//		System.out.println("--------获取原来的bean------------");
//		FactortbeanDemo bean = an.getBean("&factortbeanDemo", FactortbeanDemo.class);//获取原来的FactoryBean 对象
	}
}
