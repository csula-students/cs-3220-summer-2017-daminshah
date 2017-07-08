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
 * Servlet implementation class EditFoodAdminServlet
 */
@WebServlet("/EditFoodAdminServlet")
public class EditFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFoodAdminServlet() {
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
		
		
		List<FoodItems> items=(List<FoodItems>) getServletContext().getAttribute("items");
		FoodItems leEntry=null;
		for(FoodItems item:items)
		{
			if(item.getId()==id)
			{
				leEntry=item;
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2>Edit</h2>");
		out.println("<form method=\"post\">");
		out.println("Food name: <input name='foodname' type='text' value='"+leEntry.getName()+"'/></br>");
		out.println("Food Description: <input name='description' type='textarea' value='"+leEntry.getDescription()+"'/></br>");
		out.println("Image URL : <input name='imgurl' type='url' value='"+leEntry.getImgurl()+"'/></br>");
		out.println("Price: <input name='price' type='text' value='"+leEntry.getPrice()+"'/></br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItems> items=(List<FoodItems>) getServletContext().getAttribute("items");
		FoodItems leEntry=null;
		int index = -1;
		for (int i = 0; i < items.size(); i ++) {
			if (items.get(i).getId() == id) {
				leEntry = items.get(i);
				index = i;
			}
		}
		items.set(index, new FoodItems(
			
				leEntry.getId(),
				request.getParameter("foodname"),
			request.getParameter("description"),
			request.getParameter("imgurl"),
			Integer.parseInt(request.getParameter("price"))
			
		));
		
		getServletContext().setAttribute("entries", items);

		PrintWriter out = response.getWriter();
		out.println("Succefully Updated  </br>");

		out.println("<a href='FoodItemListAdminServlet'>Go back to FoodList</a>");
	
	}

}
