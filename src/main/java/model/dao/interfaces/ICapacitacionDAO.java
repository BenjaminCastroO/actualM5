package model.dao.interfaces;

import java.util.List;

import model.dto.Capacitacion;

public interface ICapacitacionDAO {

	public void create(Capacitacion c);
	public List<Capacitacion> read();
	public Capacitacion read(int id);
	public void update(Capacitacion c);
	public void delete(int id);
}
