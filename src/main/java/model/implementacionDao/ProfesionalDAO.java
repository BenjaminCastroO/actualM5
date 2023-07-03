package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IProfesionalDAO;
import model.dto.Profesional;


public class ProfesionalDAO implements IProfesionalDAO{

	@Override
	public void create(Profesional p) {
		String coma = "', '";
		String sql = "insert into profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id) values ('" +
				p.getRun() + coma + p.getNombre() + coma + p.getApellido() + coma + p.getCorreo() + coma + p.getTelefono() +
				coma + p.getCargo() + coma + p.getUsuarioId()+ "')";
		
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
	public List<Profesional> read() {
			List<Profesional> list = new ArrayList<Profesional>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, run, nombre, apellido, correo, telefono, cargo, usuario_id from profesional";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingProfesional(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Profesional mappingProfesional(ResultSet result) throws SQLException {
		Profesional p = new Profesional(result.getInt("id"), result.getString("run"), result.getString("nombre"),
			result.getString("apellido"), result.getString("correo"), result.getString("telefono"), 
			result.getString("cargo"), result.getInt("usuario_id"));
		return p;
	}

	@Override
	public Profesional read(int id) {
		Profesional p = null;
		try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, run, nombre, apellido, correo, telefono, cargo, usuario_id from profesional where id = " + id;
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					p = mappingProfesional(result);
				}
				
			} catch (SQLException e) {
				System.out.println("Error en read(id)");
				e.printStackTrace();
			}
		return p;
	}

	@Override
	public void update(Profesional p) {
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