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
import java.sql.Date;
import java.sql.Time;

import model.dto.Administrativo;
import model.dto.Capacitacion;
import model.dto.Usuario;
import model.service.CapacitacionService;


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
		String op = request.getParameter("op");
		if(op != null) {
			if (op.equals("create")) {
				getServletContext().getRequestDispatcher("/views/capacitacion.jsp").forward(request, response);
			}
			if(op.equals("edit")) {
				Capacitacion capacitacion = capacitacionService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("capacitacion", capacitacion);
				getServletContext().getRequestDispatcher("/views/capacitacionEdit.jsp").forward(request, response);	
			}
			if(op.equals("readOne")) {
				Capacitacion capacitacion = capacitacionService.findOne(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("capacitacion", capacitacion);
				getServletContext().getRequestDispatcher("/views/capacitacionRead.jsp").forward(request, response);
		}
		
		
		}
		request.setAttribute("listaCapacitaciones", capacitacionService.findAll());
		getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("enviar");
		if(op != null) {
			if (op.equals("capacitacion")) {
				String nombre = request.getParameter("nombre");
		        String detalle = request.getParameter("detalle");
		        Date fecha = Date.valueOf(request.getParameter("fecha"));
		        Time hora = Time.valueOf(request.getParameter("hora") + ":00");
		        String lugar = request.getParameter("lugar");
		        float duracion= Integer.parseInt(request.getParameter("duracion"));
		        int cantidad= Integer.parseInt(request.getParameter("cantidad"));
		        int clienteId= Integer.parseInt(request.getParameter("clienteId"));
		        Capacitacion capacitacion = new Capacitacion(99, nombre, detalle, fecha, hora,  lugar, duracion, cantidad, clienteId);
		        capacitacionService.create(capacitacion);
		        request.setAttribute("listaCapacitaciones", capacitacionService.findAll());
				getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
			}
			if (op.equals("editCapacitacion")) {
				String nombre = request.getParameter("nombre");
		        String detalle = request.getParameter("detalle");
		        Date fecha = Date.valueOf(request.getParameter("fecha").toString());
		        Time hora = Time.valueOf(request.getParameter("hora"));
		        String lugar = request.getParameter("lugar");
		        float duracion= Float.parseFloat(request.getParameter("duracion"));
		        int cantidad= Integer.parseInt(request.getParameter("cantidad"));
		        int clienteId= Integer.parseInt(request.getParameter("clienteId"));
		        Capacitacion capacitacion = new Capacitacion(99, nombre, detalle, fecha, hora,  lugar, duracion, cantidad, clienteId);
		        capacitacionService.update(capacitacion);
		        request.setAttribute("listaCapacitaciones", capacitacionService.findAll());
				getServletContext().getRequestDispatcher("/views/capacitacionList.jsp").forward(request, response);
			}
       
		doGet(request, response);
	}
	}

}