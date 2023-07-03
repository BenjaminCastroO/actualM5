package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IChequeoDAO;
import model.dto.Chequeo;

public class ChequeoDAO implements IChequeoDAO{

	@Override
	public void create(Chequeo c) {
		
		String sql = "insert into chequeo (visita_id, detalle, estado) values ('" +
		c.getVisitaId() + "', '" + c.getDetalle() + "', '" + c.getEstado() + "')";	
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
	public List<Chequeo> read() {
			List<Chequeo> list = new ArrayList<Chequeo>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, visita_id, detalle, estado from chequeo";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingChequeo(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Chequeo mappingChequeo(ResultSet result) throws SQLException {
		Chequeo c = new Chequeo(result.getInt("id"), result.getInt("visita_id"), result.getString("detalle"),result.getString("estado"));
		return c;
	}

	@Override
	public Chequeo read(int id) {
		Chequeo c = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, visita_id, detalle, estado from chequeo where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			c = mappingChequeo(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void update(Chequeo c) {
		/*
		String sql = "update capacitaciones set nombre = '" + c.getNombre() + "', detalle = '" + c.getDetalle() + "' where id = " + c.getId();
		
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error en update()");
			e.printStackTrace();
		}
		*/
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