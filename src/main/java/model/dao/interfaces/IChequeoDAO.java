package model.dao.interfaces;

import java.util.List;

import model.dto.Chequeo;

public interface IChequeoDAO {

	public void create(Chequeo c);

	public List<Chequeo> read();

	public Chequeo read(int id);

	public void update(Chequeo c);

	public void delete(int id);
}
