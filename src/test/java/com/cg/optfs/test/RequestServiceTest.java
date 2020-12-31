package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Request;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.service.RequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestServiceTest {
	
	@Autowired
	private RequestService requestService;

    @MockBean
	private RequestRepository requestRepo;
	
    @Test
    public void testGetAllRequest() {
	List<Request> list = new ArrayList<>();
	Mockito.when(requestRepo.findAll()).thenReturn(list);
	assertThat(requestService.viewRequest()).isEqualTo(list);
	
}
}