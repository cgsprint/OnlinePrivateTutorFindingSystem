package com.cg.optfs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(classes=OnlinePrivateTutorFindingSystemApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testLoginAdmin() 
	{
		
	}
}
