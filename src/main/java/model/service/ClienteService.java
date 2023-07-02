package model.service;
import model.dto.*;
import model.implementacionDao.ClienteDAO;

import java.util.List;


public class ClienteService {
	private ClienteDAO clienteDao = new ClienteDAO();
	
	public List<Cliente> findAll(){
		return clienteDao.read();
	}
	
	public Cliente findOne(int id) {
		return clienteDao.read(id);
	}
	
	public void create(Cliente c) {
		clienteDao.create(c);
	}
	
	public void update(Cliente c) {
		clienteDao.update(c);
	}
	
	public void delete(int id) {
		clienteDao.delete(id);
	}
}
