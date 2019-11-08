package com.reyes.forexservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExangeValueRepository extends JpaRepository<ExangeValue, Long> {
	ExangeValue findByFromAndTo(String from, String to);	
}
