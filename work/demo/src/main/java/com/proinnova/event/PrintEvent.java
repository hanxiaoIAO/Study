package com.proinnova.event;

import org.springframework.context.ApplicationEvent;

public class PrintEvent extends ApplicationEvent {

	public PrintEvent(Object source) {
		super(source);
	}

}
