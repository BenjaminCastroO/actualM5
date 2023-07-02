package model.dao.interfaces;

import java.util.List;
import model.dto.Cliente;

public interface IClienteDAO {

	public void create(Cliente c);
	public List<Cliente> read();
	public Cliente read(int id);
	public void update(Cliente c);
	public void delete(int id);
}
