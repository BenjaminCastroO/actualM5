package model.dao.interfaces;

import java.util.List;

import model.dto.Pago;

public interface IPagoDAO {

	public void create(Pago p);
	public List<Pago> read();
	public Pago read(int id);
	public void update(Pago p);
	public void delete(int id);
}
