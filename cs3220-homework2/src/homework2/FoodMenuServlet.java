package homework2;

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
 * Servlet implementation class FoodMenuServlet
 */
@WebServlet(loadOnStartup=1, urlPatterns="/admin/foods")
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		// init the application scope to have pre-set values
		List<Addfood> Homework2entry = new ArrayList<>();
		getServletContext().setAttribute("Homework2entry", Homework2entry);
	}
    public FoodMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		List<Addfood> Homework2entry=(List<Addfood>) getServletContext().getAttribute("Homework2entry");
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		
		
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h2> Food Items List </h>");
		out.println("<table border=1, padding=1px>");
		
		for (Addfood entries: Homework2entry) {
			out.println(
				"<tr>"+
					"<th> Food Name </th> "+
					"<th> Description </th> "+
					"<th> Image  </th>"+
					"<th> Price </th>"+
				"<tr>" + 
					"<td>" + entries.getName() + "</td>" + 
					"<td>" + entries.getDescription() + "</td>" +
					"<td>" +"<img src= "+entries.getImgurl()+" width=70px > </td>" +
					"<td>" + entries.getPrice() + "</td>" +
					"<td>"+
					"<a href='http://localhost:8080/cs3220-homework2/admin/foods/edit?id=" + entries.getId() + "'>Edit</a></td>" +
					"<td>"+
					"<a href='http://localhost:8080/cs3220-homework2/admin/foods/delete?id=" + entries.getId() + "'>Delete</a></td>" +
				"</tr>"
			);
		}
		out.println("</table>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/admin/foods/create'>Add Food</a>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/menu'>Go to the main menu</a>");
		
		out.println("</br>");
		out.println("</br>");
		
		//out.println("<a href='http://localhost:8080/Homework2/foods/create'>Add Food</a>");
		//out.println("<a href='FoodMenuServlet'>View Menu</a>");
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
