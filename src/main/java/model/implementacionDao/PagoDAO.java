package model.implementacionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IPagoDAO;
import model.dto.Pago;

public class PagoDAO implements IPagoDAO{

	@Override
	public void create(Pago p) {
		
		String sql = "insert into pago (cliente_id, monto, fecha_pago) values ('" +
		p.getClienteId() + "', '" + p.getMonto() + "', '" + p.getFechaPago() + "')";	
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
	public List<Pago> read() {
			List<Pago> list = new ArrayList<Pago>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, cliente_id, monto, fecha_pago from pago";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingPago(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Pago mappingPago(ResultSet result) throws SQLException {
		Pago p = new Pago(result.getInt("id"), result.getInt("cliente_id"), result.getFloat("monto"),result.getDate("fecha_pago"));
		return p;
	}

	@Override
	public Pago read(int id) {
		Pago p = null;
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			String sql = "select id, cliente_id, monto, fecha_pago from pago where id = " + id;
			ResultSet result = statement.executeQuery(sql);
			p = mappingPago(result);
			} catch (SQLException e) {
			System.out.println("Error en read(id)");
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void update(Pago u) {
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