package com.cg.optfs.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.optfs.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	
}
