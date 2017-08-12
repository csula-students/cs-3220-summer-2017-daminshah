package h4_customer;

public class Order {

	
	

	public final int id;
	public final String name;
	public final Double price;
	public String customer;
	public String status;
	
	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public Order(int id, String name, double price, String customer, String status) {
		this.id = id;
		this.name = name;
		this.price=price;
		this.customer = customer;
		this.status = status;

	}

	public int getId() {
		return id;
	}

	public String getCustomername() {
		return customer;
	}
	
	public Double getFoodprice() {
		return price;
	}

	public String getName() {
		return name;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
