package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import model.Persona;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest2 {
	@Autowired
    private MockMvc mockMvc;

	@Test
	void testLista() throws Exception{
		mockMvc.perform(get("/lista")).andDo(print());
	}
	@Test
	void testBusca() throws Exception{
		mockMvc.perform(get("/lista/uno@gmail.com")).andDo(print());
	}
	@Test
	void testAgrega() throws Exception{
		Persona p=new Persona("p4","p4@gmail.com",33);
	
		mockMvc.perform(post("/lista").contentType(MediaType.APPLICATION_JSON).content("{\"nombre\":\"p4\",\"email\":\"p4@gmail\",\"edad\":33}")).andDo(print());
		mockMvc.perform(get("/lista")).andDo(print());
	}
}
