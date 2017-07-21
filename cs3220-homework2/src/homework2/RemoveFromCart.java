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
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/shopping-cart/delete")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Addfood> cartentry = (List<Addfood>) getServletContext().getAttribute("cartentry");
		int index = -1;
		for (int i = 0; i < cartentry.size(); i++) {
			if (cartentry.get(i).getId() == id) {
				index = i;
			}
		}
		cartentry.remove(index);
		getServletContext().setAttribute("cartentry", cartentry);

		
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
			out.println("<title>Remove Item</title>");
		out.println("<h2>Your item is removed</h2>");
//		out.println("<button onclick=\"location.href='../shopping-cart'\">Go back to Shopping Cart</button>");
		out.println("<a href='http://localhost:8080/cs3220-homework2/shopping-cart'>Go to the main menu</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
