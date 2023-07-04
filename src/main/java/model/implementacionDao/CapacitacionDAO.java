package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.ICapacitacionDAO;
import model.dto.Capacitacion;

public class CapacitacionDAO implements ICapacitacionDAO{

	@Override
	public void create(Capacitacion c) {
		String coma = "', '";
		String sql = "insert into capacitacion (nombre, detalle, fecha, hora, "
				+ "lugar, duracion, cantidad, cliente_id) values ('" + 
				c.getNombre() + coma + c.getDetalle() + coma + c.getFecha() +
				coma + c.getHora() + coma + c.getLugar() + coma + c.getDuracion()
				+ coma + c.getCantidad() + coma + c.getClienteId() + "')";
		
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error en create()");
			e.printStackTrace();
		}
	}

	@Override
	public List<Capacitacion> read() {
			List<Capacitacion> list = new ArrayList<Capacitacion>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, nombre, detalle, fecha, hora, lugar, "
						+ "duracion, cantidad, cliente_id from capacitacion";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingCapacitacion(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			
			for(int i = 0; i < list.size();i++) {
				System.out.println("id " + list.get(i).getId()
				+ " nombre " + list.get(i).getNombre() +
				" detalle " + list.get(i).getDetalle());
			}
			return list;
	}

	private Capacitacion mappingCapacitacion(ResultSet result) throws SQLException {
		Capacitacion c = new Capacitacion(
			result.getInt("id"), result.getString("nombre"), result.getString("detalle"),
			result.getDate("fecha"), result.getTime("hora"), result.getString("lugar"),
			result.getFloat("duracion"), result.getInt("cantidad"), result.getInt("cliente_id"));
		return c;
	}

	@Override
	public Capacitacion read(int id) {
		Capacitacion c = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, nombre, detalle, fecha, hora, lugar,"
					+ "duracion, cantidad, cliente_id from capacitacion"
					+ " where id = " + id;    
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				c = mappingCapacitacion(result);
			}
			
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void update(Capacitacion c) {
		
		String sql = "update capacitacion set nombre = '" + c.getNombre() + "', detalle = '" + c.getDetalle() + "', fecha = '" + c.getFecha() + "', hora = '" + c.getHora() + "', lugar = '" + c.getLugar() + "', duracion = '" + c.getDuracion() + "', cantidad = '" + c.getCantidad() + "' where id = " + c.getId();
		
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error en update()");
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		/*String sql = "delete from capacitaciones where id = " + id;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			System.out.println("Error en delete()1");
			Statement statement = connection.createStatement();
			System.out.println("Error en delete()2");
			statement.execute(sql);
			System.out.println("Error en delete()3");
		} catch (SQLException e) {
			System.out.println("Error en delete()4");
			e.printStackTrace();
		}
		*/
	}

}
