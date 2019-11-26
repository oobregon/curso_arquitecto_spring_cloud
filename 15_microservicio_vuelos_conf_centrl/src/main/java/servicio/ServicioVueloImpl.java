package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoVuelos;
import model.Vuelo;

@Service
public class ServicioVueloImpl implements ServicioVuelo {
	@Autowired
	DaoVuelos daoV;

	@Override
	public List<Vuelo> obtenerDisponibilidadVuelos(int numPlazas) {
		return daoV.encontrarPorAlMenosPlazas(numPlazas);
	}

	@Override
	public Vuelo obtenerVuelo(int idVuelo) {
		return daoV.findById(idVuelo).get();
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		int plazasActuales = this.obtenerVuelo(vuelo.getIdvuelo()).getPlazas();
		if(vuelo.getPlazas() <= plazasActuales) {
			vuelo.setPlazas(plazasActuales-vuelo.getPlazas());
			daoV.save(vuelo);
		}
	}

	@Override
	public void actualizar(int idVuelo, int numPlazas) {
		Vuelo vuelo = this.obtenerVuelo(idVuelo);
		if(numPlazas <= vuelo.getPlazas()) {
			vuelo.setPlazas(vuelo.getPlazas() - numPlazas);
			daoV.save(vuelo);
		}
	}
}
