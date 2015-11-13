package es.ugarrio.elmercadilloagricola.service;

import java.util.List;

import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;


public interface ProvinciaService {
	
	public Provincia save(Provincia account);
	public Provincia delete(int id) throws EMCAException;
	public Provincia update(Provincia provincia) throws EMCAException;
	public List<Provincia> findAll();
	public Provincia findById(int id);
	//List<Provincia> findByCodProvincia(String codProvincia);
	
	
	
}
