package controller;
import java.util.*;
import java.util.Objects;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Capacitacion;
import service.CapacitacionService;


@WebServlet("/capacitacion")
public class CapacitacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CapacitacionService capacitacionService = new CapacitacionService();;
	      

    public CapacitacionController() {
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
		
		String opcion = "";
		opcion = request.getParameter("btnMostrar");
	
			if (!(Objects.isNull(opcion))) {
				if (opcion.equals("1")) {
				request.setAttribute("listaCapacitaciones", capacitacionService.findAll());
				getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
				}
			} else {
		getServletContext().getRequestDispatcher("/views/capacitacion.jsp").forward(request, response);}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//solución al problema: para evitar que al redireccionar desde login a capacitacion se llame al post de capacitacion controller se verifica
		// que el request tenga el parametro idcap distinto de null ya que el codigo del metodo post está reservado para el uso del formulario de creación
		// de una capacitación.
		if((Objects.isNull(request.getParameter("idcap")))) {
			getServletContext().getRequestDispatcher("/views/capacitacion.jsp").forward(request, response);
		}
		
		int id = Integer.parseInt(request.getParameter("idcap"));
        int rut = Integer.parseInt(request.getParameter("rut"));
        String dia = request.getParameter(request.getParameter("dia"));
        String hora = request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        int cantAsistentes = Integer.parseInt(request.getParameter("cantAsistentes"));
        
        Capacitacion capacitacion = new Capacitacion(id, rut, dia, hora, lugar, duracion, cantAsistentes);
        capacitacionService.agregarCapacitacion(capacitacion);
        request.setAttribute("listaCapacitaciones", capacitacionService.findAll());
		getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
	}

}