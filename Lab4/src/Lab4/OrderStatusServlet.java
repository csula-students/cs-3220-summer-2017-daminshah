package Lab4;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderStatusServlet
 */
@WebServlet("/OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
	
	
	
	public void init() {

		//Sample

		List<Order> Lab4sampleorders = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		Lab4sampleorders.add(new Order(Lab4sampleorders.size(), "Burger", "Eric",
				"IN_QUEUE", df.format(date)));
		Lab4sampleorders.add(new Order(Lab4sampleorders.size(), "Pizza","Eric", "IN_QUEUE",df.format(date)));
		Lab4sampleorders.add(new Order(Lab4sampleorders.size(), "Sandwiche","Eric", "IN_QUEUE", df.format(date)));
		getServletContext().setAttribute("Lab4sampleorders", Lab4sampleorders);
	}
    public OrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/admin/order-statuses.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
