package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Accidente;
import model.service.AccidenteService;


@WebServlet("/asistente")
public class AsistenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AccidenteService asistenteService = new AccidenteService();;
	      

    public AsistenteController() {
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
			if (op.equals("create")) {
				getServletContext().getRequestDispatcher("/views/asistente.jsp").forward(request, response);
			}
		}
		request.setAttribute("listaAccidentes", asistenteService.findAll());
		getServletContext().getRequestDispatcher("/views/asistenteList.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String detalle = request.getParameter("detalle");
		doGet(request, response);
	}

}