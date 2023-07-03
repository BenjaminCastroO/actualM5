package model.dao.interfaces;

import java.util.List;

import model.dto.Asesoria;

public interface IAsesoriaDAO {

	public void create(Asesoria a);
	public List<Asesoria> read();
	public Asesoria read(int id);
	public void update(Asesoria a);
	public void delete(int id);
}
