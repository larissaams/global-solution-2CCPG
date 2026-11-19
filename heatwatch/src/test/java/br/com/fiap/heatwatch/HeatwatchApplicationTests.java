package br.com.fiap.heatwatch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "heatwatch.menu.enabled=false")
class HeatwatchApplicationTests {

	@Test
	void contextLoads() {
	}

}
