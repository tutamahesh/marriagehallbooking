package com.hallbooking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SupervisorServiceApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertDoesNotThrow(this ::doNotThrowException);
	}
	private void doNotThrowException()
	{
		//this method will throw an exception
	}
}
