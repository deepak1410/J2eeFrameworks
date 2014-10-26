package org.deepak.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class PlayEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayEvent(Object source) {
		super(source);
	}
	
	public String toString() {
		return "Cricket Match Play event has occurred.";
	}
	
	/*
	 * Steps for handling Spring Events
	 * Have an Event class that extends ApplicationEvent class and has the implicit constructor inside it.
	 * Have an event listener class to listen to the events. It implements ApplicationListener interface and defines method onApplicationEvent-
	 * which has code to execute when event occurs. Here it is CrickScoreEventListener
	 * Have a member variable of type ApplicationEventPublisher in the bean class which implements interface ApplicationEventPublisherAware
	 * and autowire it's setter method.
	 * Execute the publishEvent method of the ApplicationEventPublisher class passing the event as parameter. 
	 * 
	 */

}
