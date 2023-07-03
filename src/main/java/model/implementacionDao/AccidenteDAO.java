package model.implementacionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IAccidenteDAO;
import model.dto.Accidente;

public class AccidenteDAO implements IAccidenteDAO{

	@Override
	public void create(Accidente a) {
		
		String sql = "insert into accidente (cliente_id, fecha_accidente, detalle) values ('" +
		a.getClienteId() + "', '" + a.getFechaAccidente()+ "', '" + a.getDetalle() + "')";	
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
	public List<Accidente> read() {
			List<Accidente> list = new ArrayList<Accidente>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, cliente_id, fecha_accidente, detalle from accidente";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingAccidente(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Accidente mappingAccidente(ResultSet result) throws SQLException {
		Accidente a = new Accidente(result.getInt("id"), result.getInt("cliente_id"), result.getDate("fecha_accidente"),result.getString("detalle"));
		return a;
	}

	@Override
	public Accidente read(int id) {
		Accidente a = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, cliente_id, fecha_accidente, detalle from accidente where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			a = mappingAccidente(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void update(Accidente a) {
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