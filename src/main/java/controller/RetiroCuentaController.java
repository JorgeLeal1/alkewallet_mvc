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
@WebServlet("/RetiroCuentaController")
public class RetiroCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetiroCuentaController() {
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
        
      //Obtiene variable de session del run del usuario logeado
        HttpSession misession = request.getSession();
        String run = (String) misession.getAttribute("run");
        
       // System.out.println(run);
        //Conexion a Base de datos wallet
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
    	//convierte los datos de request al formato de la tabla
    	Double saldo_actual = Double.parseDouble(request.getParameter("saldo_actual"));
    	Double saldo = Double.parseDouble(request.getParameter("saldo"));
        
    	//crea objeto daro cuenta
		DaoCuenta dao = new DaoCuenta(conexion);
		
		//Actualiza el saldo de la tabla cuenta
		double saldo_nuevo = saldo_actual - saldo;
		
        System.out.println("saldo_actual"+ saldo_actual);
        System.out.println("saldo"+saldo);
        System.out.println("saldo_nuevo"+saldo_nuevo);
		
    	//Actualiza el saldo de la tabla cuenta
		dao.actualizarSaldoCuenta(run, saldo_nuevo);
		
		//Redirige a viewAllCuentas
		RequestDispatcher rd=request.getRequestDispatcher("viewAllCuentas");  
        rd.forward(request, response);  
	}

}
