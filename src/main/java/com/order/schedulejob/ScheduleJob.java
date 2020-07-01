package com.order.schedulejob;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.order.service.MyService;

@Component
public class ScheduleJob {

	private static final Logger log = LoggerFactory.getLogger(ScheduleJob.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	MyService service;

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		//System.out.println("The time is now {}" + dateFormat.format(new Date()));
		log.info("The time is now {}", dateFormat.format(new Date()));
		
		System.out.println("Processing at " + service.getNextMessage());
	}
}
