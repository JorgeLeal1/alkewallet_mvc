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

import conexion.ConexionDB;
import dao.DaoCuenta;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet("/CuentaController")
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //Conexion a BD
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
    	//Crea objeto cuenta
		DaoCuenta dao = new DaoCuenta(conexion);
		
		//dao.obtenerTodoCuenta(), obtiene todas las cuentas ordenadas por run cliente
		request.setAttribute("cuentas",dao.obtenerTodoCuenta());  
		
		//redirecciona a vista Viewall
		RequestDispatcher rd=request.getRequestDispatcher("cuentas/viewAll.jsp");  
        rd.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //Conexion a BD
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
    	//Crea objeto cuenta
		DaoCuenta dao = new DaoCuenta(conexion);
		
		//dao.obtenerTodoCuenta(), obtiene todas las cuentas ordenadas por run cliente
		request.setAttribute("cuentas",dao.obtenerTodoCuenta());  
		
		//redirecciona a vista Viewall
		RequestDispatcher rd=request.getRequestDispatcher("cuentas/viewAll.jsp");  
        rd.forward(request, response);  
	}

}
