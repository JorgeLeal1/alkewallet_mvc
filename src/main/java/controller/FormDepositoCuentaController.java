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
@WebServlet("/FormDepositoCuentaController")
public class FormDepositoCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDepositoCuentaController() {
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
        
        
        HttpSession misession = request.getSession();
        String run = (String) misession.getAttribute("run");
        
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
		DaoCuenta dao = new DaoCuenta(conexion);
		request.setAttribute("saldo",dao.consultarSaldoPorRun(run));  
		
		System.out.println(dao.consultarSaldoPorRun(run));

        //request.setAttribute("run",misession.getAttribute("run"));  
		// se redirige a la pantalla listado
		RequestDispatcher rd=request.getRequestDispatcher("cuentas/realizarDepositos.jsp");  
        rd.forward(request, response);  
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
        
        ConexionDB conexionBD = new ConexionDB();
    	Connection conexion = conexionBD.establecerConexion();
    	
		DaoCuenta dao = new DaoCuenta(conexion);
		request.setAttribute("saldo",dao.consultarSaldoPorRun(run));  
		
		System.out.println(dao.consultarSaldoPorRun(run));

        //request.setAttribute("run",misession.getAttribute("run"));  
		// se redirige a la pantalla listado
		RequestDispatcher rd=request.getRequestDispatcher("cuentas/realizarDepositos.jsp");  
        rd.forward(request, response);  
        
	}

}
