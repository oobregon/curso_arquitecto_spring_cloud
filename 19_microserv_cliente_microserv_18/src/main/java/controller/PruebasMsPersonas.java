package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@RestController
public class PruebasMsPersonas {
	// Inyectame el valor de esta propiedad.
	// Spring busca en todos los ficheros de properties del classpath en busca 
	// de la propiedad indicada.
	// @Value("${propia.servicio.rest.personas.eureka}")	
	String url = "http://servicio-personas-casa/personas";
	
	// Podemos inyectar la clase RestTemplate porque ya ha sido instanciada mediante la clase
	// Application, que tiene incorporada la anotacion @Configuration
	@Autowired
	RestTemplate template;
	
	
	@GetMapping(value = "/probar")
	public void ejecutarPrueba() {				
		String dato = template.getForObject(url+"/prueba",String.class);
		int numero = 5;
	}
	
	
	@GetMapping(value = "/buscar/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona bucarPersona(@PathVariable("email") String email) {
		Persona persona = null;
		Persona[] personas = template.getForObject(url+"/lista",Persona[].class);
		for(Persona p:personas) {
			if(p.getEmail().equals(email)) {
				persona=p;
			}
		}
		return persona;
	}	
	
	@GetMapping(value = "/buscar",produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona[] bucarPersona() {		
		Persona[] personas = template.getForObject(url+"/lista",Persona[].class);
		return personas;
	}
	
	// http://localhost:8000/personas/lista
	@GetMapping(value = "/crearPersona",consumes = MediaType.APPLICATION_JSON_VALUE,
									    produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona crearPersona(@RequestBody Persona p) {
		template.postForLocation(url+"/lista",p);
		return p;
	}
}
