package com.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

import com.app.model.Book;


@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {
	  private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);
	
	  @StreamListener("input")
	  @SendTo("output") public Book consumeMessage(Book book) {
	  logger.info("Consume payload : " + book.getName());
	  book.setName(book.getName().toUpperCase()); 
	  return book;
	  }
	 

	    
	/*
	 * @StreamListener("input") public void consumeMessage(Book book) {
	 * logger.info("Consume payload : " + book.getName());
	 * book.setName(book.getName().toUpperCase());
	 * 
	 * }
	 */
	    public static void main(String[] args) {
	        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	    }
}
