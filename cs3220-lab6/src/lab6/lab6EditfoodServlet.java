package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab6EditfoodServlet
 */
@WebServlet("/lab6EditfoodServlet")
public class lab6EditfoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lab6EditfoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("Submit"));
		FoodItemsDAO dao=new FoodItemsDAO();
		FoodItems lab6items=dao.get(id).get();
		
		request.setAttribute("item", lab6items);
		request.getRequestDispatcher("WEB-INF/admin/lab6editfood.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		FoodItems updatedFood = new FoodItems(Integer.parseInt(request.getParameter("Submit")),
				request.getParameter("name"), request.getParameter("image"), request.getParameter("description"),
				Double.parseDouble(request.getParameter("price")));
		FoodItemsDAO dao = new FoodItemsDAO();
		dao.update(updatedFood);

		response.sendRedirect("lab6inventory");
		//request.getRequestDispatcher("WEB-INF/admin/lab6inventory.jsp").forward(request, response);
		
	}

}
