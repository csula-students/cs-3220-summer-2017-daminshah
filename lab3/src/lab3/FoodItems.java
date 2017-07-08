package lab3;

public class FoodItems {

	int id;
	String name;
	String Description;
	String imgurl;
	int price;
	
	public FoodItems(int id,String name,String Description,String imgurl,int price){
		
		this.id=id;
		this.name=name;
		this.Description=Description;
		this.imgurl=imgurl;
		this.price=price;
		
		
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
