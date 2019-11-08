package com.reyes.forexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExangeValueRepository repository;
	
	@GetMapping("/currency-exange/from/{from}/to/{to}")
	public ExangeValue getExangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExangeValue exangeValue = repository.findByFromAndTo(from, to);
		exangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exangeValue;
	}
}
