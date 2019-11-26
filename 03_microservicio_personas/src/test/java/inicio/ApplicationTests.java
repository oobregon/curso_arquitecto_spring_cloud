package inicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import controller.PersonasController;
import model.Persona;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PersonasController.class)
class ApplicationTests {
	PersonasController controller;
	
	@Test
	void testPersonas() {
		RestTemplate restTemplate = new RestTemplate(); 
		Persona[] personas = restTemplate.getForObject("http://localhost:8000/personas/lista",Persona[].class);
		//Persona[] personas= controller.recuperarPersonas();
		assertEquals(personas.length,3);
	}

}
