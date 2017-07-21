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
 * Servlet implementation class DeleteFoodServlet
 */
@WebServlet("/admin/foods/delete")
public class DeleteFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFoodServlet() {
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
		List<Addfood> entry=(List<Addfood>)getServletContext().getAttribute("entry");
		
		int index=-1;
		for (int i = 0; i < entry.size(); i ++) {
			if (entry.get(i).getId() == id) {
				index = i;
			}
		}
		entry.remove(index);
		getServletContext().setAttribute("entry", entry);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Succesfully Deleted");
		out.println("<a href='http://localhost:8080/cs3220-homework2/admin/foods'>Go back to List</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
