package model.implementacionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IAsistenteDAO;
import model.dto.Asistente;

public class AsistenteDAO implements IAsistenteDAO{

	@Override
	public void create(Asistente a) {
		
		String sql = "insert into asistente (capacitacion_id, usuario_id) values ('" +
		a.getCapacitacionId() + "', '" + a.getUsuarioId() + "')";	
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
	public List<Asistente> read() {
			List<Asistente> list = new ArrayList<Asistente>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select capacitacion_id, usuario_id from asistente";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingAsistente(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Asistente mappingAsistente(ResultSet result) throws SQLException {
		Asistente a = new Asistente(result.getInt("capacitacion_id"), result.getInt("usuario_id"));
		return a;
	}

	@Override
	public Asistente read(int id) {
		Asistente a = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select capacitacion_id, usuario_id from asistente where capacitacion_id = " + id;
			ResultSet result = statement.executeQuery(sql);
			a = mappingAsistente(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void update(Asistente a) {
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