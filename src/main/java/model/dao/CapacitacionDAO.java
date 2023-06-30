package model.dao;

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
		
		String sql = "insert into capacitaciones (nombre, detalle) values ('" + c.getNombre() + "', '" + c.getDetalle() + "')";
		
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
				String sql = "select id, nombre, detalle from capacitaciones";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingCapacitacion(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Capacitacion mappingCapacitacion(ResultSet result) throws SQLException {
		Capacitacion c = new Capacitacion(
				result.getInt("Id"), result.getString("nombre"), result.getString("detalle"));
		return c;
	}

	@Override
	public Capacitacion read(int id) {
		Capacitacion c = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, nombre, detalle from capacitaciones where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			c = mappingCapacitacion(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void update(Capacitacion c) {
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