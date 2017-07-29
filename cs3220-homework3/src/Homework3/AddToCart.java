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
    	List<Addfood> Homework3cartentry=new ArrayList<>();
    	getServletContext().setAttribute("Homework3cartentry", Homework3cartentry);
    
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("Submit"));
		List<Addfood> Homework3items = (List<Addfood>) getServletContext().getAttribute("Homework3items");

		Addfood leentry = null;

		for (Addfood foodentries : Homework3items) {
			if (foodentries.getId() == id) {
				
				leentry = foodentries;
			}
		}
		
		List<Addfood> Homework3cartentry = (List<Addfood>) getServletContext().getAttribute("Homework3cartentry");

		Homework3cartentry.add(new Addfood(id, leentry.getName(), leentry.getUrl(), leentry.getDescription(),
			leentry.getPrice()));
		System.out.println(leentry.getName());


		getServletContext().setAttribute("Homework3cartentry", Homework3cartentry);
		
		response.sendRedirect("ShoppingCart.jsp");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
