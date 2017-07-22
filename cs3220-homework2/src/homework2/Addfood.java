package homework2;

public class Addfood {
	
	 
		 int id;
		 String name; 
		 String description;
		 String imgurl;
		// double price;
		int price;
		
		public Addfood(int id,String name,String description,String imgurl,int price){
			this.id=id;
			this.name=name;
			this.description=description;
			this.imgurl=imgurl;
			this.price=price;
		}
		
		public int getId(){
			return id;
		}
		
		public String getName(){
			return name; 
		}
		
		public String getDescription(){
		
			return description;
		}
		
		public String getImgurl(){
			return imgurl;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setImg_url(String imgurl) {
			this.imgurl = imgurl;
		}
		
		
	


	}
