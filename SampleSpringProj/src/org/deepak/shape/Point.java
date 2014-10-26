package org.deepak.shape;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/*
 * This class implements ApplicationContextAware and BeanNameAware to retrieve the Bean and ApplicationContext created
 */
public class Point implements ApplicationContextAware, BeanNameAware {

	int x;
	int y;
	private ApplicationContext context = null;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
	
	@Override
	public void setBeanName(String bean) {
		System.out.println("The bean name is: " + bean);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		
	}


}
