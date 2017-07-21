package Homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    	List<Addfood> cartentry=new ArrayList<>();
    	getServletContext().setAttribute("cartentry", cartentry);
    
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("Submit"));
		List<Addfood> items = (List<Addfood>) getServletContext().getAttribute("items");

		Addfood leentry = null;

		for (Addfood foodentries : items) {
			if (foodentries.getId() == id) {
				
				leentry = foodentries;
			}
		}
		
		List<Addfood> cartentry = (List<Addfood>) getServletContext().getAttribute("cartentry");

		cartentry.add(new Addfood(id, leentry.getName(), leentry.getUrl(), leentry.getDescription(),
			leentry.getPrice()));
		System.out.println(leentry.getName());


		getServletContext().setAttribute("cartentry", cartentry);
		
		response.sendRedirect("http://localhost:8080/cs3220-homework3/ShoppingCart.jsp");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
