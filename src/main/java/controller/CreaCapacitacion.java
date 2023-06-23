package controller;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Capacitacion;
import service.CapacitacionService;

//import cl.awakelab.models.service.StudentService;


@WebServlet("/creaCapacitacion")
public class CreaCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CapacitacionService capacitacionService;
	
       

    public CreaCapacitacion() {
        super();
        capacitacionService = new CapacitacionService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/capacitacion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("idcap"));
        int rut = Integer.parseInt(request.getParameter("rut"));
        String dia = request.getParameter(request.getParameter("dia"));
        String hora = request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        int cantAsistentes = Integer.parseInt(request.getParameter("cantAsistentes"));
        
        Capacitacion capacitacion = new Capacitacion(id, rut, dia, hora, lugar, duracion, cantAsistentes);
        capacitacionService.agregarCapacitacion(capacitacion);
        
        request.setAttribute("creaCapacitacion", capacitacionService.findAll());
		getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
	}

}