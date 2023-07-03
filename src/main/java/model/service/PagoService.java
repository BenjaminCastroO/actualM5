package model.service;
import model.dto.*;
import model.implementacionDao.PagoDAO;

import java.util.List;


public class PagoService {
	private PagoDAO pagoDao = new PagoDAO();
	
	public List<Pago> findAll(){
		return pagoDao.read();
	}
	
	public Pago findOne(int id) {
		return pagoDao.read(id);
	}
	
	public void create(Pago p) {
		pagoDao.create(p);
	}
	
	public void update(Pago p) {
		pagoDao.update(p);
	}
	
	public void delete(int id) {
		pagoDao.delete(id);
	}
}
