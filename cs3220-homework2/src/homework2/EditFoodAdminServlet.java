package homework2;

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
@WebServlet("/admin/foods/edit")
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
		@SuppressWarnings("unchecked")
		List<Addfood> entry=(List<Addfood>) getServletContext().getAttribute("entry");
		Addfood leEntry=null;
		for(Addfood entries:entry){
			if(entries.getId()==id){
				leEntry=entries;
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> DAMIN'S CAFE</h1>");
		out.println("<body style='background-color: burlywood;'>");
		out.println("<img  src=https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb width=70px alt= logo /> </br>");
		out.println("<h1>Edit Food</h1>");
		out.println("<form method=\"post\">");
		out.println("Food Name:<input name='name' type='text' value='"+leEntry.getName()+"'/><br> ");
		out.println("<hr>");
		out.println("Food Description: <input name='description' type='textarea' value='"+leEntry.getDescription()+"'/></br>");	
		out.println("<hr>");
		out.println("Image URL:<input name='imgurl' type='text'value='"+leEntry.getImgurl()+"'/><br> ");
		out.println("<hr>");
		out.println("Price: <input name='price' type='text' value='"+leEntry.getPrice()+"'/></br> ");
		out.println("<hr>");
		out.println("<button> Edit</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		List<Addfood> entry = (List<Addfood>) getServletContext().getAttribute("entry");
		Addfood leEntry = null;
		int index = -1;
		for (int i = 0; i < entry.size(); i ++) {
			if (entry.get(i).getId() == id) {
				leEntry = entry.get(i);
				index = i;
			}
		}
		entry.set(index, new Addfood(
			leEntry.getId(),
			request.getParameter("name"),
			request.getParameter("Description"),
			request.getParameter("imgurl"),
			Integer.parseInt(request.getParameter("price"))
		));
		getServletContext().setAttribute("entry", entry);

		PrintWriter out = response.getWriter();
		out.println("Succefully Updated  </br>");

		out.println("<a href='http://localhost:8080/cs3220-homework2/admin/foods'>Go back to FoodList</a>");



	}

}
