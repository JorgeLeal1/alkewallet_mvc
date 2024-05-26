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
import model.Cuenta;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet("/DepositoCuentaController")
public class DepositoCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositoCuentaController() {
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
        
        
        HttpSession misession = request.getSession();
        String run = (String) misession.getAttribute("run");
        
       // System.out.println(run);
        
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
    	//convierte los datos de request al formato de la tabla
    	Double saldo_actual = Double.parseDouble(request.getParameter("saldo_actual"));
    	Double saldo = Double.parseDouble(request.getParameter("saldo"));
        
		DaoCuenta dao = new DaoCuenta(conexion);
		
		double saldo_nuevo = saldo_actual + saldo;
		
        System.out.println("saldo_actual"+ saldo_actual);
        System.out.println("saldo"+saldo);
        System.out.println("saldo_nuevo"+saldo_nuevo);
		
		dao.actualizarSaldoCuenta(run, saldo_nuevo);  
		
		RequestDispatcher rd=request.getRequestDispatcher("viewAllCuentas");  
        rd.forward(request, response);  
	}

}
