package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IAdministrativoDAO;
import model.dto.Administrativo;


public class AdministrativoDAO implements IAdministrativoDAO{

	@Override
	public void create(Administrativo a) {
		String coma = "', '";
		String sql = "insert into administrativo (run, nombre, apellido, correo, area, usuario_id) values ('" +
				a.getRun() + coma + a.getNombre() + coma + a.getApellido() + coma + a.getCorreo() + coma + a.getArea() +
				coma + a.getUsuarioId()	+ "')";
		
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
	public List<Administrativo> read() {
			List<Administrativo> list = new ArrayList<Administrativo>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, run, nombre, apellido, correo, area, usuario_id from administrativo";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingAdministrativo(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Administrativo mappingAdministrativo(ResultSet result) throws SQLException {
		Administrativo a = new Administrativo(result.getInt("id"), result.getString("run"), result.getString("nombre"),
			result.getString("apellido"), result.getString("correo"), result.getString("area"), result.getInt("usuario_id"));
		return a;
	}

	@Override
	public Administrativo read(int id) {
		Administrativo a = null;
		try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, run, nombre, apellido, correo, area, usuario_id from administrativo where id = " + id;
				ResultSet result = statement.executeQuery(sql);
				a = mappingAdministrativo(result);
			} catch (SQLException e) {
				System.out.println("Error en read(id)");
				e.printStackTrace();
			}
		return a;
	}

	@Override
	public void update(Administrativo a) {
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