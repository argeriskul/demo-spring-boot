package ru.neutrino;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.neutrino.dao.EntityDAO;
import ru.neutrino.service.ServicePlanet;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ServicePlanet servicePlanet;

	@Test
	void contextLoads() {
	}

	@Test
	void readDataFromDB() {
		servicePlanet.showallPlanet();
	}
}
