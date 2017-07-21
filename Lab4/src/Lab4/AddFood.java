package Lab4;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddFood {
	
	
	String name;
	String url;
	String description;
	double price;
	int id;
	
	
	public AddFood (int id,String name,String url,String description,double price
			) {
		this.name=name;
		this.url=url;
		this.description=description;
		this.price=price;
		this.id=id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public String getUrl() {
		return url;
	}


	public String getDescription() {
		return description;
	}


	public double getPrice() {
		return price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	

}
