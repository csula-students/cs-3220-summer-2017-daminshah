package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab6CreatefoodadminServlet
 */
@WebServlet("/lab6CreatefoodadminServlet")
public class lab6CreatefoodadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lab6CreatefoodadminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/WEB-INF/admin/lab6createfood.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        Double price = Double.parseDouble(request.getParameter("price"));
        
        
        FoodItems lab6items=new FoodItems(-1, name,image,description, price);
        
        
        FoodItemsDAO dao=new FoodItemsDAO();
        dao.add(lab6items);
        
       response.sendRedirect("lab6inventory");

}

}
