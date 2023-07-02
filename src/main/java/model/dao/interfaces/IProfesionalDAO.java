package model.dao.interfaces;

import java.util.List;
import model.dto.Profesional;

public interface IProfesionalDAO {

	public void create(Profesional p);
	public List<Profesional> read();
	public Profesional read(int id);
	public void update(Profesional p);
	public void delete(int id);
}
