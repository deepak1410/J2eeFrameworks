package org.deepak.annotations;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.deepak.event.PlayEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class Batsman implements Cricketer, ApplicationEventPublisherAware {

	private String name;
	private PlayerDetails playerDetails;
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public PlayerDetails getPlayerDetails() {
		return playerDetails;
	}
	
	// @Required // Required annotation makes sure that a particular member variable is required and hence it avoids throwing NPE.
	//@Autowired // Autowired annotation wires a Bean with another bean and provides DI. 
	//@Qualifier(value="playerInfo") // Qualifier can be used to distinguish the beans if multiple beans have been created for a class.
	@Resource(name="playerDetails") // Resource annotation is another way to provide Autowiring which is under jsr-250 annotations.
	public void setPlayerDetails(PlayerDetails playerDetails) {
		this.playerDetails = playerDetails;
	}

	@Override
	public void play() {
		String deliveryInfo = getMessageSource().getMessage("deliveryInfo", new Object[]{getPlayerDetails().getHandedness(), getPlayerDetails().getPlayerType()},
				"Info unavailable", Locale.CHINESE);
		System.out.println(deliveryInfo);
		
		PlayEvent playEvent = new PlayEvent(this);
		publisher.publishEvent(playEvent);
	}
	
	@PostConstruct
	public void batstmanIn(){
		System.out.println("The batsman is In for batting");
	}
	
	@PreDestroy
	public void batsManOut() {
		System.out.println("The Batsman is out. He played a pull shot and caught by fielder.");
	}

	@Override
	@Autowired
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}

}
