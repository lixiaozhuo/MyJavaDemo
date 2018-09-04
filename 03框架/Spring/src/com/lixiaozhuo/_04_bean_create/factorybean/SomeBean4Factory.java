package com.lixiaozhuo._04_bean_create.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBean4Factory implements FactoryBean<SomeBean4> {

	@Override
	public SomeBean4 getObject() throws Exception {
		return new SomeBean4();
	}

	@Override
	public Class<?> getObjectType() {
		return SomeBean4.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
