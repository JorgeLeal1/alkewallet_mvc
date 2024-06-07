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

/**
 * Servlet implementation class CuentaController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
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
        
        //Conexion a Base de datos wallet
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
                
        //Obtiene variable de session del run del usuario logeado
        HttpSession misession = request.getSession();
        String run = (String) misession.getAttribute("run");
        
    	//crea objeto daro cuenta
    	//Obtiene el saldo actual por el run del usuario logeado
		DaoCuenta daoCuenta = new DaoCuenta(conexion);
		request.setAttribute("saldo",daoCuenta.consultarSaldoPorRun(run));  
		
		//Redirige a home
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
        rd.forward(request, response);  

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        
        
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //Conexion a Base de datos wallet
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
                
        //Obtiene variable de session del run del usuario logeado
        HttpSession misession = request.getSession();
        String run = (String) misession.getAttribute("run");
        
    	//crea objeto daro cuenta
    	//Obtiene el saldo actual por el run del usuario logeado
		DaoCuenta daoCuenta = new DaoCuenta(conexion);
		request.setAttribute("saldo",daoCuenta.consultarSaldoPorRun(run));  
		
		//Redirige a home
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
        rd.forward(request, response);  
        
	}

}
