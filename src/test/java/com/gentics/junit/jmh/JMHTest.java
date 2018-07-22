package com.gentics.junit.jmh;

import org.junit.AfterClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JMHTest {

	private static StopWatchLogger logger = StopWatchLogger.logger(JMHTest.class);

	@Test
	public void testPerformance() {

		StopWatch.loggingStopWatch(logger, "basic-test", 20, (step) -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@AfterClass
	public static void writeReport() throws JsonProcessingException {
		logger.flush();
	}
}
