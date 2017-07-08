package lab3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFoodAdminServlet
 */
@WebServlet("/DeleteFoodAdminServlet")
public class DeleteFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		List<FoodItems> items=(List<FoodItems>)getServletContext().getAttribute("items");
		
		int index=-1;
		for (int i = 0; i < items.size(); i ++) {
			if (items.get(i).getId() == id) {
				index = i;
			}
		}
		items.remove(index);
		getServletContext().setAttribute("entries", items);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Succesfully Deleted");
		out.println("<a href='FoodItemListAdminServlet'>Go back to List</a>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
