package com.polansky.batching;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StopWatch;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@ActiveProfiles("nonbatch")
class NonBatchTest {

	Logger log = LoggerFactory.getLogger(NonBatchTest.class);

	@Autowired
	TransactionalSaver transactionalSaver;

	@Test
	void saveUsers() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		transactionalSaver.saveInTransaction();

		stopWatch.stop();
		log.info("non batch took {} ms", stopWatch.getLastTaskTimeMillis());

		assertTrue(true);
	}

}
