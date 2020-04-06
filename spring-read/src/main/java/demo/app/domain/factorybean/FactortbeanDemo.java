package demo.app.domain.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactortbeanDemo implements FactoryBean<demobyFactorybean> {
	@Override
	public demobyFactorybean getObject() throws Exception {
		return new demobyFactorybean();
	}

	@Override
	public Class<?> getObjectType() {
		return demobyFactorybean.class;
	}
}
