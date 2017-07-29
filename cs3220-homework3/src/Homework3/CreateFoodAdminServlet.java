package Homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Homework3.Addfood;



/**
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet("/create")
public class CreateFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	
    	
    	List<Addfood> Homework3items=new ArrayList<>();
    	getServletContext().setAttribute("Homework3items", Homework3items);
    	
//    	items.add(new Addfood(items.size(), "Pizza", "http://www.cicis.com/media/1176/pizza_trad_pepperonibeef.png", "Delicious", 21.88));
//    	items.add(new Addfood(items.size(), "Burger", "http://www.cicis.com/media/1176/pizza_trad_pepperonibeef.png", "Delicious", 25.89));
//    	items.add(new Addfood(items.size(), "Sandwich", "http://www.cicis.com/media/1176/pizza_trad_pepperonibeef.png", "Delicious", 11.88));
//        
//        
    	
    
    	
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//	List<Addfood> items=(List<Addfood>) getServletContext().getAttribute("items");
			List<Addfood> Homework3items=(List<Addfood>) getServletContext().getAttribute("Homework3items");
		
			
		
			Homework3items.add(new Addfood(Homework3items.size(), request.getParameter("name"), request.getParameter("image"), request.getParameter("description"),Double.parseDouble((request.getParameter("price")))));
		
		
		getServletContext().setAttribute("Homework3items", Homework3items);
		
		
		request.getRequestDispatcher("/admin/inventory.jsp").forward(request, response);
		
		
	}

}
