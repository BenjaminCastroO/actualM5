package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IVisitaDAO;
import model.dto.Visita;


public class VisitaDAO implements IVisitaDAO{

	@Override
	public void create(Visita v) {
		String coma = "', '";
		String sql = "insert into visita (cliente_id, fecha, hora, lugar, realizado, detalle, profesional_id) values ('" +
				v.getClienteId() + coma + v.getFecha() + coma + v.getHora() + coma + v.getLugar() + coma + v.isRealizado() +
				coma + v.getDetalle() + coma + v.getProfesionalId()+ "')";
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
	public List<Visita> read() {
			List<Visita> list = new ArrayList<Visita>();	
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, cliente_id, fecha, hora, lugar, realizado, detalle, profesional_id from visita";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingVisita(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Visita mappingVisita(ResultSet result) throws SQLException {
		Visita v = new Visita(result.getInt("id"), result.getInt("cliente_id"), result.getDate("fecha"),
			result.getTime("hora"), result.getString("lugar"), result.getBoolean("realizado"), 
			result.getString("detalle"), result.getInt("profesional_id"));
		return v;
	}

	@Override
	public Visita read(int id) {
		Visita v = null;
		try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, cliente_id, fecha, hora, lugar, realizado, detalle, profesional_id from visita where id = " + id;
				ResultSet result = statement.executeQuery(sql);
				v = mappingVisita(result);
			} catch (SQLException e) {
				System.out.println("Error en read(id)");
				e.printStackTrace();
			}
		return v;
	}

	@Override
	public void update(Visita p) {
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