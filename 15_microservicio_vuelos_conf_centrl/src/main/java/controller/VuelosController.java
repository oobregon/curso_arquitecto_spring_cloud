package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import servicio.ServicioVuelo;

@RestController
public class VuelosController {
	
	@Autowired
	private ServicioVuelo sVuelo;
	
	@GetMapping (value ="/disponibilidadVuelos/{plazas}")
	public List<Vuelo> obtenerVuelosDisponibles(@PathVariable("plazas") int numPlazas) {
		return sVuelo.obtenerDisponibilidadVuelos(numPlazas);
	}
	
	@PutMapping (value = "/actualizarPlazas", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazas(@RequestBody Vuelo vuelo) {
		sVuelo.actualizar(vuelo);
		return sVuelo.obtenerVuelo(vuelo.getIdvuelo());
	}
	
	@PutMapping (value = "/actualizarPlazas", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazas(@RequestParam("idVuelo") int idVuelo,
								  @RequestParam("plazas") int numPlazas) {
		sVuelo.actualizar(idVuelo, numPlazas);
		return sVuelo.obtenerVuelo(idVuelo);
	}
}
