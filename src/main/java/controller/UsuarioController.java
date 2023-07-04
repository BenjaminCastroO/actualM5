package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Administrativo;
import model.dto.Cliente;
import model.dto.Profesional;
import model.dto.Usuario;
import model.service.AdministrativoService;
import model.service.ClienteService;
import model.service.ProfesionalService;
import model.service.UsuarioService;

// usuario  
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
UsuarioService usuarioService = new UsuarioService();
AdministrativoService administrativoService = new AdministrativoService();
ClienteService clienteService = new ClienteService();
ProfesionalService profesionalService = new ProfesionalService();
    public UsuarioController() {
        super();
        }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("isLogged") == null) {
			getServletContext().getRequestDispatcher("/login").forward(request, response);
		}
		boolean isLogged = (boolean)session.getAttribute("isLogged");	
		if (!isLogged) {
			getServletContext().getRequestDispatcher("/login").forward(request, response);
		} 		
		String op = request.getParameter("op");
		if(op != null) {
			request.setAttribute("op", op);
			if (op.equals("createAdministrativo")) {		
				getServletContext().getRequestDispatcher("/views/usuarioAdministrativo.jsp").forward(request, response);
			}
			if(op.equals("editAdministrativo")) {
				Administrativo admin = administrativoService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("admin", admin);
				getServletContext().getRequestDispatcher("/views/usuarioAdministrativoEdit.jsp").forward(request, response);	
			}
			if(op.equals("readOneAdministrativo")) {
				Administrativo admin = administrativoService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("admin", admin);
				getServletContext().getRequestDispatcher("/views/usuarioAdministrativoRead.jsp").forward(request, response);	
			}
			if (op.equals("readAdministrativo")) {		
				request.setAttribute("listaAdministrativos", administrativoService.findAll());
				getServletContext().getRequestDispatcher("/views/usuarioAdministrativoList.jsp").forward(request, response);
			}
			
			
			if (op.equals("createCliente")) {		
				getServletContext().getRequestDispatcher("/views/usuarioCliente.jsp").forward(request, response);
			}
			if(op.equals("editCliente")) {
				Cliente cliente = clienteService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("cliente", cliente);
				System.out.println(cliente.toString());
				getServletContext().getRequestDispatcher("/views/usuarioClienteEdit.jsp").forward(request, response);	
			}
			if(op.equals("readOneCliente")) {
				Cliente cliente = clienteService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("cliente", cliente);
				getServletContext().getRequestDispatcher("/views/usuarioClienteRead.jsp").forward(request, response);	
			}
			if (op.equals("readCliente")) {	
				
				request.setAttribute("listaClientes", clienteService.findAll());
				getServletContext().getRequestDispatcher("/views/usuarioClienteList.jsp").forward(request, response);
				
				
			}
 
			
			if (op.equals("createProfesional")) {		
				getServletContext().getRequestDispatcher("/views/usuarioProfesional.jsp").forward(request, response);
			}
			if(op.equals("editProfesional")) {
				Profesional profesional= profesionalService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("profesional", profesional);
				getServletContext().getRequestDispatcher("/views/usuarioProfesionalEdit.jsp").forward(request, response);	
			}
			if(op.equals("readOneProfesional")) {
				Profesional profesional= profesionalService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("profesional", profesional);
				getServletContext().getRequestDispatcher("/views/usuarioProfesionalRead.jsp").forward(request, response);	
			}
			if (op.equals("readProfesional")) {		
				request.setAttribute("listaProfesionales", profesionalService.findAll());
				getServletContext().getRequestDispatcher("/views/usuarioProfesionalList.jsp").forward(request, response);
			
			}
		}
		request.setAttribute("listaUsuarios", usuarioService.findAll());
		getServletContext().getRequestDispatcher("/views/usuarioList.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post de usuario");
		String op = request.getParameter("enviar");
		if(op != null) {
			if (op.equals("admin")) {
				String nombre = request.getParameter("nombre");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        Usuario user = new Usuario(99, nombre, username, password);
		        String apellido = request.getParameter("apellido");
		        String run = request.getParameter("run");
		        String correo = request.getParameter("mail");
		        String area = request.getParameter("area");
		        user = usuarioService.create(user);
		        int usuarioId = user.getId();
		        Administrativo admin = new Administrativo(99, run, nombre, apellido,
		        		correo,  area, usuarioId);
		        administrativoService.create(admin);
			}
			if (op.equals("editAdmin")) {
				String nombre = request.getParameter("nombre");
		        int id = Integer.parseInt(request.getParameter("id"));
		        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		        String apellido = request.getParameter("apellido");
		        String run = request.getParameter("run");
		        String correo = request.getParameter("mail");
		        String area = request.getParameter("area");
		        Administrativo admin = new Administrativo(id, run, nombre, apellido,
		        		correo,  area, usuarioId);
		        administrativoService.update(admin);
		        request.setAttribute("listaAdministrativos", administrativoService.findAll());
				getServletContext().getRequestDispatcher("/views/usuarioAdministrativoList.jsp").forward(request, response);
			}
			if (op.equals("cliente")) {
				String nombre = request.getParameter("nombre");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        Usuario user = new Usuario(99, nombre, username, password);
		        String rut = request.getParameter("rut");
		        String apellido = request.getParameter("apellido");
		        String correo = request.getParameter("correo");
		        String telefono = request.getParameter("telefono");
		        String afp = request.getParameter("afp");
		        String sistemaSalud = request.getParameter("sistemaSalud");
		        String direccion = request.getParameter("direccion");
		        String comuna = request.getParameter("comuna");
		        int edad = Integer.parseInt(request.getParameter("edad"));
		        user = usuarioService.create(user);
		        int usuarioId = user.getId();
		        Cliente cliente = new Cliente(99, rut, nombre, apellido,
		        		correo, telefono, afp, sistemaSalud, direccion, comuna, 
		        		edad, usuarioId);
		        clienteService.create(cliente);
			}
			if (op.equals("editCliente")) {
				String nombre = request.getParameter("nombre");
		        int id = Integer.parseInt(request.getParameter("id"));
		        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		        String rut = request.getParameter("rut");
		        String apellido = request.getParameter("apellido");
		        String correo = request.getParameter("correo");
		        String telefono = request.getParameter("telefono");
		        String afp = request.getParameter("afp");
		        String sistemaSalud = request.getParameter("sistemaSalud");
		        String direccion = request.getParameter("direccion");
		        String comuna = request.getParameter("comuna");
		        int edad = Integer.parseInt(request.getParameter("edad"));
		        Cliente cliente= new Cliente(id, rut, nombre, apellido,
		        		correo, telefono, afp, sistemaSalud, direccion, comuna, 
		        		edad, usuarioId);
		        clienteService.update(cliente);
			}
			
			if (op.equals("profesional")) {
				String nombre = request.getParameter("nombre");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        Usuario user = new Usuario(99, nombre, username, password);
		        String run = request.getParameter("run");
		        String apellido = request.getParameter("apellido");
		        String correo = request.getParameter("correo");
		        String telefono = request.getParameter("telefono");
		        String cargo = request.getParameter("cargo");
		        user = usuarioService.create(user);
		        int usuarioId = user.getId();
		        Profesional profesional = new Profesional(99, run, nombre, apellido,
		        		correo, telefono, cargo, usuarioId);
		        profesionalService.create(profesional);
			}
			if (op.equals("editProfesional")) {
				String nombre = request.getParameter("nombre");
		        int id = Integer.parseInt(request.getParameter("id"));
		        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		        String run = request.getParameter("run");
		        String apellido = request.getParameter("apellido");
		        String correo = request.getParameter("correo");
		        String telefono = request.getParameter("telefono");
		        String cargo = request.getParameter("cargo");
		        Profesional profesional= new Profesional(id, run, nombre, apellido,
		        		correo, telefono, cargo, usuarioId);
		        profesionalService.update(profesional);
		        request.setAttribute("listaProfesionales", profesionalService.findAll());
				getServletContext().getRequestDispatcher("/views/usuarioProfesionalList.jsp").forward(request, response);
		       
			}
		}
        
		doGet(request, response);
	}

}