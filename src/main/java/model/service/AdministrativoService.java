package model.service;
import model.dto.*;
import model.implementacionDao.AdministrativoDAO;

import java.util.List;


public class AdministrativoService {
	private AdministrativoDAO administrativoDao = new AdministrativoDAO();
	
	public List<Administrativo> findAll(){
		return administrativoDao.read();
	}
	
	public Administrativo findOne(int id) {
		return administrativoDao.read(id);
	}
	
	public void create(Administrativo a) {
		administrativoDao.create(a);
	}
	
	public void update(Administrativo a) {
		administrativoDao.update(a);
	}
	
	public void delete(int id) {
		administrativoDao.delete(id);
	}
}
