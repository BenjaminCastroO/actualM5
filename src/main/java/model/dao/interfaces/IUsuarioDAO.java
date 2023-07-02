package model.dao.interfaces;

import java.util.List;

import model.dto.Usuario;

public interface IUsuarioDAO {

	public Usuario create(Usuario u);
	public List<Usuario> read();
	public Usuario read(int id);
	public void update(Usuario u);
	public void delete(int id);
}
