package VendingMachine;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief Beverage Class
 * 
 */

public class Product{
	private String name;
	private int price;
	private int numOfPurchased;
	private int numOfStock;
	
	public Product(String name, int price, int purchased, int stock){
		this.name = name;
		this.price = price;
		this.numOfPurchased = purchased;
		this.numOfStock = stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPurchased() {
		return numOfPurchased;
	}
	public void setPurchased(int numOfPurchased) {
		this.numOfPurchased = numOfPurchased;
	}
	public int getStock() {
		return numOfStock;
	}
	public void setStock(int numOfStock) {
		this.numOfStock = numOfStock;
	}
	
	
}