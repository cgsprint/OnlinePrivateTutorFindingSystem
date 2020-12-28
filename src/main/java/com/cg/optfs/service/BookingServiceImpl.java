package com.cg.optfs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Booking;
import com.cg.optfs.repository.BookingRepository;

@Transactional
@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepositoryRepo;
	

	@Override
	public List<Booking> viewBooking() {
		List<Booking> list = bookingRepositoryRepo.findAll();
		return list;
	}

}
