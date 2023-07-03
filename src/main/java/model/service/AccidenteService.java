package model.service;
import model.dto.*;
import model.implementacionDao.AccidenteDAO;

import java.util.List;


public class AccidenteService {
	private AccidenteDAO accidenteDao = new AccidenteDAO();
	
	public List<Accidente> findAll(){
		return accidenteDao.read();
	}
	
	public Accidente findOne(int id) {
		return accidenteDao.read(id);
	}
	
	public void create(Accidente a) {
		accidenteDao.create(a);
	}
	
	public void update(Accidente a) {
		accidenteDao.update(a);
	}
	
	public void delete(int id) {
		accidenteDao.delete(id);
	}
}
