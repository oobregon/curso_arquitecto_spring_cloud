package servicio;

import java.util.List;

import model.Vuelo;

public interface ServicioVuelo {	
	List<Vuelo> obtenerDisponibilidadVuelos(int numPlazas);
	Vuelo obtenerVuelo(int idVuelo);
	void actualizar(Vuelo vuelo);
	void actualizar(int idVuelo,int numPlazas);
}
