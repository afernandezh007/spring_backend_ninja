package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.MyService;

@Service("myService")
public class MyServiceImpl implements MyService {

	private static final Log LOGGER = LogFactory.getLog(MyServiceImpl.class);
	
	@Override
	public void sayHello() {
		LOGGER.info("HELLO FROM MYSERVICE");
	}

}
