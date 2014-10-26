package org.deepak.shape;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/*
 * This class is created for the post process execution after bean creation.
 */
public class DisplayBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After Initialization postProcessAfterInitialization: beanName=" + beanName );
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before Initialization postProcessBeforeInitialization: beanName=" + beanName );
		return bean;
	}

}
