package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.ConexionDB;
import dao.DaoCuenta;
import dao.DaoLogin;
import model.Cuenta;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();

    	//convierte los datos de request al formato de la tabla
    	String run = request.getParameter("run");
    	String contrasena = request.getParameter("contrasena");
    	
    	//System.out.println(run);//System.out.println(contrasena);
	
    	DaoLogin dao = new DaoLogin(conexion);
    	boolean result = dao.validarLogin(run, contrasena);
    
    	//System.out.println(result);
    	if(result) {
    		
    		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
            rd.forward(request, response);  	
    		
            HttpSession misession = request.getSession(true);
            misession.setAttribute("run", run);

    	}else {
    		//Si no esta logeado lo retorna al login
    		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
            rd.forward(request, response);  
    	}
        
	}

}
