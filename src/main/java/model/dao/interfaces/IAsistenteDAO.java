package model.dao.interfaces;

import java.util.List;

import model.dto.Asistente;

public interface IAsistenteDAO {

	public void create(Asistente a);
	public List<Asistente> read();
	public Asistente read(int id);
	public void update(Asistente a);
	public void delete(int id);
}
