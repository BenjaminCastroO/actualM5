package model.dao.interfaces;

import java.util.List;

import model.dto.Accidente;

public interface IAccidenteDAO {

	public void create(Accidente a);
	public List<Accidente> read();
	public Accidente read(int id);
	public void update(Accidente a);
	public void delete(int id);
}
