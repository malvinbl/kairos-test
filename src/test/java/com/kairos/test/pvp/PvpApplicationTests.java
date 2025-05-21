package com.kairos.test.pvp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:e-commerce;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=TRUE",
		"spring.sql.init.mode=never"
})
class PvpApplicationTests {

	@Autowired
	private PvpApplication pvpApplication;

	@Test
	void contextLoads() {
		assertThat(pvpApplication).isNotNull();
	}

}
