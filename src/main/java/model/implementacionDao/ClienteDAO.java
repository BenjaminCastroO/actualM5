package model.implementacionDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.cnn.Conexion;
import model.dao.interfaces.IClienteDAO;
import model.dto.Cliente;


public class ClienteDAO implements IClienteDAO{

	@Override
	public void create(Cliente c) {
		String coma = "', '";
		String sql = "insert into cliente (rut, nombre, apellido, correo, telefono, "
				+ "afp, sistema_salud, direccion, comuna, edad, usuario_id) values ('" +
				c.getRut() + coma + c.getNombre() + coma + c.getApellido() + coma + c.getCorreo() 
				+ coma + c.getTelefono() + coma + c.getAfp()+ coma + c.getSistemaSalud()
				+ coma + c.getDireccion()+ coma + c.getComuna()+ coma + c.getEdad()
				+ coma + c.getUsuarioId()+ "')";
		
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
	public List<Cliente> read() {
			List<Cliente> list = new ArrayList<Cliente>();
			
			try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, rut, nombre, apellido, correo, telefono,"
						+ "afp, sistema_salud, direccion, comuna, edad, usuario_id from cliente";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					list.add(mappingCliente(result));
				}
			} catch (SQLException e) {
				System.out.println("Error en read()");
				e.printStackTrace();
			}
			return list;
	}

	private Cliente mappingCliente(ResultSet result) throws SQLException {
		Cliente c = new Cliente(result.getInt("id"), result.getString("rut"), result.getString("nombre"),
			result.getString("apellido"), result.getString("correo"), result.getString("telefono"), 
			result.getString("afp"), result.getString("sistema_salud"), result.getString("direccion"), 
			result.getString("comuna"), result.getInt("edad"), result.getInt("usuario_id"));
		return c;
	}

	@Override
	public Cliente read(int id) {
		Cliente c = null;
		try {
				java.sql.Connection connection = Conexion.getConexion();
				Statement statement = connection.createStatement();
				String sql = "select id, rut, nombre, apellido, correo, telefono, "
						+ "afp, sistema_salud, direccion, comuna, edad, usuario_id from cliente where id = " + id;
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					c = mappingCliente(result);
				}
			} catch (SQLException e) {
				System.out.println("Error en read(id)");
				e.printStackTrace();
			}
		return c;
	}

	@Override
	public void update(Cliente c) {
		System.out.println(c.toString());
		String sql = "update cliente set rut = '" + c.getRut() + "', "
				+ "nombre = '" + c.getNombre() + "', apellido ='" + c.getApellido() + 
				"', correo = '" + c.getCorreo() + "', telefono = '" + c.getTelefono() + 
				"', afp = '" + c.getAfp() + "', sistema_salud = '" + c.getSistemaSalud()+
				"', direccion = '" + c.getDireccion() + "', comuna = '" + c.getComuna()+
				"', edad = " + c.getEdad() + ", usuario_id = " + c.getUsuarioId() +
				 " where id = " + c.getId();
		try {
			java.sql.Connection connection = Conexion.getConexion();
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error en update()");
			e.printStackTrace();
		}
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