package com.cg.optfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.optfs.service.EbookServiceImpl;

@SpringBootApplication
public class OnlinePrivateTutorFindingSystemApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(OnlinePrivateTutorFindingSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinePrivateTutorFindingSystemApplication.class, args);
		
		LOGGER.debug("Debug for Applicatin");
		
		LOGGER.info("Application starts..");
	}

}
