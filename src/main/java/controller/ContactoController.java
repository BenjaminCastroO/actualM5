package controller;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Administrativo;
import model.dto.Usuario;
@WebServlet("/contacto")
public class ContactoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public void Contacto() {
        
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
		getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("enviar");
		if(op != null) {
			if (op.equals("contacto")) {
				String nombre = request.getParameter("nombre");
		        String email = request.getParameter("email");
		        String mensaje = request.getParameter("mensaje");
		        System.out.println("Nombre: "+ nombre);
		        System.out.println("E-Mail: "+ email);
		        System.out.println("Mensaje: "+ mensaje);
		        
			}
		doGet(request, response);
	}
	}
}
