package model.service;

import java.util.List;

import model.dao.CapacitacionDAO;
import model.dao.UsuarioDAO;
import model.dto.Capacitacion;
import model.dto.Usuario;

public class UsuarioService {
	private UsuarioDAO usuariodao = new UsuarioDAO();
	
	public List<Usuario> findAll(){
		return usuariodao.read();
	}
	
	public Usuario findOne(int id) {
		return usuariodao.read(id);
	}
	
	public void create(Usuario u) {
		usuariodao.create(u);
	}
	
	public void update(Usuario u) {
		usuariodao.update(u);
	}
	
	public void delete(int id) {
		usuariodao.delete(id);
	}
}
