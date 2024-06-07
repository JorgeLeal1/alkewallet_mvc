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
		// Elimina variable de session
		request.getSession().invalidate();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();

    	//los parametros del formulario login los traspasa a variables
    	String run = request.getParameter("run");
    	String contrasena = request.getParameter("contrasena");

    	
    	//System.out.println(run);//System.out.println(contrasena);
    	DaoLogin dao = new DaoLogin(conexion);
    	boolean result = dao.validarLogin(run, contrasena);// valida si el usuario ingresado esta en la BD
    
    	//System.out.println(result);
    	// Si el resultado es true, El usuarios existe, si el resultado es false, no existe en la BD con esos parametros
    	if(result) {
 
    		DaoCuenta daoCuenta = new DaoCuenta(conexion);
    		request.setAttribute("saldo",daoCuenta.consultarSaldoPorRun(run));// Busca el saldo de la cuenta por el Run logeado
    		//System.out.println(daoCuenta.consultarSaldoPorRun(run));

    		//Crea variable de sesion por run del usuario
            HttpSession misession = request.getSession(true);
            misession.setAttribute("run", run);
    			
            //Redirecciona a Home
    		RequestDispatcher rd=request.getRequestDispatcher("home");  
            rd.forward(request, response);  
           
    	}else {
    		//Redirecciona al Index(Login) y envia mensaje con error
            request.setAttribute("mensaje", new String("Run o Contraseña incorrectos, favor ingrese datos nuevamente!!"));
    		
            //Si no esta logeado lo retorna al login
    		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.forward(request, response);  
    	}
        
	}

}
