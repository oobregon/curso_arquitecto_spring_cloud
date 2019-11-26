package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface DaoVuelos extends JpaRepository<Vuelo,Integer> {
	@Query("select v From Vuelo v where v.plazas >= ?1")
	List<Vuelo> encontrarPorAlMenosPlazas(int numPlazas);
}
