package Lab4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<img src='https://images.pexels.com/photos/2059/restaurant-red-beans-coffee.jpg?h=350&auto=compress&cs=tinysrgb 'class='logo'  >");      
		out.println("<h1>DAMIN'S CAFE-Admin</h1>");



	}

}
