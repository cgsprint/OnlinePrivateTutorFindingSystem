package com.cg.optfs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.optfs.entity.Admin;

@SpringBootTest(classes = OnlinePrivateTutorFindingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testLoginAdmin() {
		Admin admin = new Admin(1,"Tejas","tejas123","tejas");

		ResponseEntity<Admin> postResponse = restTemplate.postForEntity(getRootUrl() + "/admin/login?username=tejas123&password=tejas",
				admin,
				Admin.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());

	}
}
