
public class Product implements Comparable<Product> {
	static int current_ID = 0;
	
	int ID;
	private String description;
	private double price;
	
	public int getID() {
		return ID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	Product(String description, double price) {
		this.ID = current_ID+=1;
		this.description = description;
		this.price = price;
	}
	
	Product() {
		this.ID = current_ID+=1;
	}
	
	Product(Product product) {
		this.ID = current_ID+=1;
		this.description = product.description;
		this.price = product.price;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.2f", this.description, this.price);
	}
	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		
		if (this.getPrice() > o.getPrice()) {
			return -1;
		}
		else if (this.getPrice() < o.getPrice()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
