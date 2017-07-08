package lab3;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodItemListAdminServlet
 */
@WebServlet(loadOnStartup=1,urlPatterns="/FoodItemListAdminServlet")
public class FoodItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodItemListAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()
    {
    	List<FoodItems> items=new ArrayList<>();
    	//entries.add(new GuestBookEntry("Eric", "Hello",entries.size()));
    	//entries.add(new GuestBookEntry("John", "Hi there!!",entries.size()));

    	
    	
    	getServletContext().setAttribute("items", items);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		List<FoodItems> items=(List<FoodItems>) getServletContext().getAttribute("items");
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		
		
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2> Food Items List </h>");
		out.println("<table border=1, padding=1px>");
		
		for (FoodItems item: items) {
			out.println(
				"<tr>"+
					"<th> Food Name </th> "+
					"<th> Description </th> "+
					"<th> Image  </th>"+
					"<th> Price </th>"+
				"<tr>" + 
					"<td>" + item.getName() + "</td>" + 
					"<td>" + item.getDescription() + "</td>" +
					"<td>" +"<img src= "+item.getImgurl()+" width=70px > </td>" +
					"<td>" + item.getPrice() + "</td>" +
					"<td>"+
					"<a href='EditFoodAdminServlet?id=" + item.getId() + "'>Edit</a></td>" +
					"<td>"+
					"<a href='DeleteFoodAdminServlet?id=" + item.getId() + "'>Delete</a></td>" +
				"</tr>"
			);
		}
		out.println("</table>");
		out.println("<a href='FoodMenuServlet'>View Menu</a>");
		//out.println("<a href='guestbook/create'>Add comemnt</a>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
