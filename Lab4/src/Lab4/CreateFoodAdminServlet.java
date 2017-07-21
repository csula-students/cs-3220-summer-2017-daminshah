package Lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CreateFoodAdminServlet
 */
@WebServlet("/CreateFoodAdminServlet")
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
    	List<AddFood> items=new ArrayList<>();
    	getServletContext().setAttribute("items", items);
    
    	
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
		//doGet(request, response);
			List<AddFood> items=(List<AddFood>) getServletContext().getAttribute("items");
		
		
		items.add(new AddFood(items.size(), request.getParameter("name"), request.getParameter("image"), request.getParameter("description"),Double.parseDouble((request.getParameter("price")))));
		
		
		getServletContext().setAttribute("items", items);
		
		
		request.getRequestDispatcher("/admin/inventory.jsp").forward(request, response);
		
		
	}

}
