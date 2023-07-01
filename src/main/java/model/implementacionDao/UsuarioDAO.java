package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IUsuarioDAO;
import model.dto.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

	@Override
	public void create(Usuario u) {
		
		String sql = "insert into usuario (nombre, username, password) values ('" +
		u.getNombre() + "', '" + u.getUsername() + "', '" + u.getPassword() + "')";
		
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
	public List<Usuario> read() {
			List<Usuario> list = new ArrayList<Usuario>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, nombre, username, password from usuario";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingUsuario(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Usuario mappingUsuario(ResultSet result) throws SQLException {
		Usuario u = new Usuario(result.getInt("id"), result.getString("nombre"), result.getString("username"),result.getString("password"));
		return u;
	}

	@Override
	public Usuario read(int id) {
		Usuario u = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, nombre, username, password from usuario where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			u = mappingUsuario(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void update(Usuario u) {
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