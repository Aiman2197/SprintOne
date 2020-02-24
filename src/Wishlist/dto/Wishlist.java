package Wishlist.dto;


public class Wishlist {
	private int cost;
	private String Product_Name;
	private String Manufacturer;
	private String Category;
	private String Product_Id;
	public Wishlist(int cost, String product_Name, String manufacturer,String Category,String Product_Id) {
		super();
		this.cost = cost;
		Product_Name = product_Name;
		Manufacturer = manufacturer;
		this.Category = Category;
		this.Product_Id = Product_Id;
	}
	public String getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}
	public String getCategory() {
		return Category;
	}
	public Wishlist() {
		
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "Wishlist [cost=" + cost + ", Product_Name=" + Product_Name + ", Manufacturer=" + Manufacturer + "]";
	}
	public void setCategory(String string) {
		// TODO Auto-generated method stub
		Category=Category;
	}
	
	
}																																																																																																																																																																																																																																																																																																																																																																																																																																																															