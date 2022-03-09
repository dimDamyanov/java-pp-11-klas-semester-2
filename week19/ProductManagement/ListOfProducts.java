import java.util.ArrayList;
import java.util.Collections;

public class ListOfProducts {
	private ArrayList<Product> products;
	
	public ListOfProducts() {
		this.products = new  ArrayList<Product>();
	}
	
	public void add (Product product) {
		products.add(product);
	}
	public String[] toArray() {
		String[] result;
		result = new String[products.size()];
		for(int i = 0; i < products.size(); i++) {
			result[i] = products.get(i).toString();
		}
		return result;
	}
	
	public double averagePrice() {
		double pricesSum = 0;
		for(int i = 0; i < products.size(); i++) {
			pricesSum += products.get(i).getPrice();
		}
		return pricesSum / products.size();
	}
	
	public String toString() {
		String result = "[";
		for(int i=0;i<products.size();i++) {
			result += products.get(i).toString();
			if (i != products.size() - 1)
				result += "; ";
		}
		result += "]";
		return result;
	}
	
	public void sortByPrice() {
		Collections.sort(products);
	}

}
