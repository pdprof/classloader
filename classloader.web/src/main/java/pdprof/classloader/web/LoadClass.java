package pdprof.classloader.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pdprof.classloader.a.A;
import pdprof.classloader.a.AA;
import pdprof.classloader.b.B;
import pdprof.classloader.p.P;

/**
 * Servlet implementation class ClassLoad
 */
@WebServlet("/loadclasses")
public class LoadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClass() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.printClassLoader();
		
		A a = new A();
		a.printClassLoader();
		a.loadB();
		a.loadP();
		a.loadAA();
		AA aa = new AA();
		aa.printClassLoader();
		
		B b = new B();
		b.printClassLoader();
		b.loadA();
		b.loadP();
		
		P p = new P();
		p.printClassLoader();
		p.loadA();
		p.loadB();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void printClassLoader() {
		System.out.println(this.getClass().getName() + " is loaded from " + this.getClass().getClassLoader());
	}

}
