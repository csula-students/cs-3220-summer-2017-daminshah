package Homework3;

import java.util.Date;

public class Order {
	
	enum Statuses {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	 int id;
	 Addfood food;
	 String name;
	 Statuses statuses;
	 
	 Date date;

	 
	   
	  public Order(int id, Addfood food, String name, Statuses statuses, Date date) {
			this.id = id;
			this.food = food;
			this.name = name;
			this.statuses = statuses;
			this.date = date;

		}

	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Addfood getFood() {
		return food;
	}

	public void setFood(Addfood food) {
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Statuses getStatuses() {
		return statuses;
	}

	public void setStatuses(Statuses statuses) {
		this.statuses = statuses;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		 
	  

}
