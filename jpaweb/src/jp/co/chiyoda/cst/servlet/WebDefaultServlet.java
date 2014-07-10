package jp.co.chiyoda.cst.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpaweb.Test01;

/**
 * Servlet implementation class WebDefaultServlet
 */
@WebServlet("/test")
public class WebDefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebDefaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess");
		
		String id = request.getParameter("id");
		String description = request.getParameter("description");
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String noofpage = request.getParameter("noOfPage");
		String price = request.getParameter("price");
		String illustrations = request.getParameter("illustrations");

		Test01 test = new Test01(id, description, illustrations, isbn, noofpage, price, title);
		test.entry();
		
		RequestDispatcher rd = request.getRequestDispatcher("/testResult.jsp");
		rd.forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
