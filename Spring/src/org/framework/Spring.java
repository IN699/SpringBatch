package org.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		
		HelloWorld h1=context.getBean(HelloWorld.class);
		h1.setMessage("Hello");
		h1.getMessage();

	}

}
