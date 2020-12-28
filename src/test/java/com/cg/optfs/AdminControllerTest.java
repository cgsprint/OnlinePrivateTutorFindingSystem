package com.cg.optfs;

import org.springframework.boot.web.server.LocalServerPort;

public class AdminControllerTest {

	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
}
