package model.dao.interfaces;

import java.util.List;
import model.dto.Administrativo;

public interface IAdministrativoDAO {

	public void create(Administrativo a);
	public List<Administrativo> read();
	public Administrativo read(int id);
	public void update(Administrativo a);
	public void delete(int id);
}
