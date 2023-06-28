package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();

    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		HttpSession session = request.getSession();
		
		
		if (loginService.login(username, password)) {	
			session.setAttribute("isLogged", true);
			
			getServletContext().getRequestDispatcher("/capacitacion").forward(request, response);	
		} else {
			
			session.setAttribute("isLogged", false);
			getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
			
		}
     }
		

}
