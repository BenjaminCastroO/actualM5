package model.implementacionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IAsesoriaDAO;
import model.dto.Asesoria;

public class AsesoriaDAO implements IAsesoriaDAO{

	@Override
	public void create(Asesoria a) {
		
		String sql = "insert into asesoria (nombre, detalle, profesional_id, cliente_id) values ('" +
		a.getNombre() + "', '" + a.getDetalle() + "', '" + a.getProfesionalId()+ "', '" + a.getClienteId() + "')";	
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
	public List<Asesoria> read() {
			List<Asesoria> list = new ArrayList<Asesoria>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, nombre, detalle, profesional_id, cliente_id from asesoria";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingAsesoria(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Asesoria mappingAsesoria(ResultSet result) throws SQLException {
		Asesoria a = new Asesoria(result.getInt("id"), result.getString("nombre"), result.getString("detalle"),
				result.getInt("profesional_id"),result.getInt("cliente_id"));
		return a;
	}

	@Override
	public Asesoria read(int id) {
		Asesoria a = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, nombre, detalle, profesional_id, cliente_id from asesoria where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			a = mappingAsesoria(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void update(Asesoria a) {
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