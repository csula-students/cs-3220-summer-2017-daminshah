package Midterm;


import java.util.List;

public class Restaurant {
	
	int id;
	String name;
	String url;
	List<Integer> designRatings;
	List<Integer> tasteRatings;
	
	
	public Restaurant(int id,String name,String url,List<Integer> designRatings,List<Integer> tasteRatings)
	{
		
		this.id=id;
		this.name=name;
		this.url=url;
		this.designRatings=designRatings;
		this.tasteRatings=tasteRatings;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<Integer> getDesignRatings() {
		return designRatings;
	}


	public void setDesignRatings(List<Integer> designRatings) {
		this.designRatings = designRatings;
	}


	public List<Integer> getTasteRatings() {
		return tasteRatings;
	}


	public void setTasteRatings(List<Integer> tasteRatings) {
		this.tasteRatings = tasteRatings;
	}
	
	
	
	
	
	

}
