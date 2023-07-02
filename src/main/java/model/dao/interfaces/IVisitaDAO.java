package model.dao.interfaces;

import java.util.List;

import model.dto.Visita;

public interface IVisitaDAO {

	public void create(Visita v);
	public List<Visita> read();
	public Visita read(int id);
	public void update(Visita v);
	public void delete(int id);
}
