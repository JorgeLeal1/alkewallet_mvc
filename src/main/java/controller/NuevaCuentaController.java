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
import dao.DaoUsuario;
import model.Cliente;
import model.Cuenta;
import model.Usuario;
/**
 * Servlet implementation class CuentaController
 */
@WebServlet("/NuevaCuentaController")
public class NuevaCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaCuentaController() {
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
    	String nombre1 = request.getParameter("nombre1");
    	String nombre2 = request.getParameter("nombre2");
    	String appaterno = request.getParameter("appaterno");
    	String apmaterno = request.getParameter("apmaterno");
    	
    	//public Cliente(String run, String nombre1, String nombre2, String appaterno, String apmaterno) {
    	Cliente cliente = new Cliente(run, nombre1, nombre2, appaterno, apmaterno);
    	
    	
    	int nroCuenta = Integer.parseInt(request.getParameter("nrocuenta"));
    	String alias = request.getParameter("alias");
    	String banco = request.getParameter("banco");
    	Double saldo = 0.0; // por apertura de cuenta
    	//Double saldo = Double.parseDouble(request.getParameter("saldo"));
    	
    	//public Cuenta(int id, int nroCuenta, String alias, String banco, double saldo, Cliente titular) {
    	Cuenta cuenta = new Cuenta(nroCuenta, alias, banco, saldo, cliente);

    	//Se insertan los datos
		DaoCuenta dao = new DaoCuenta(conexion);
		dao.insertarCuenta(cuenta);

		
		
    	String nombreUsuario = request.getParameter("nombreUsuario");
    	String email = request.getParameter("email");    	
    	String contrasena = request.getParameter("contrasena");
		
    	//	public Usuario(Integer user_id, String nombre, String correo_electronico, String contrasena) {
    	Usuario usuario = new Usuario(nombreUsuario, email,  contrasena, cliente);
    	
    	//Se insertan los datos
		DaoUsuario dao_usuario = new DaoUsuario(conexion);
		dao_usuario.insertarUsuario(usuario);
    	
		
		request.setAttribute("cuentas",dao.obtenerTodoCuenta());  
		
		// se redirige a la pantalla listado
		RequestDispatcher rd=request.getRequestDispatcher("cuentas/viewAll.jsp");  
        rd.forward(request, response);  
        
       
	}

}
