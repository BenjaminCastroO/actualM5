package model.service;
import model.dto.*;
import model.implementacionDao.ChequeoDAO;

import java.util.List;


public class ChequeoService {
	private ChequeoDAO chequeoDao = new ChequeoDAO();
	
	public List<Chequeo> findAll(){
		return chequeoDao.read();
	}
	
	public Chequeo findOne(int id) {
		return chequeoDao.read(id);
	}
	
	public void create(Chequeo c) {
		chequeoDao.create(c);
	}
	
	public void update(Chequeo c) {
		chequeoDao.update(c);
	}
	
	public void delete(int id) {
		chequeoDao.delete(id);
	}
}
