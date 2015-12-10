package eshop;

public class Order {

	private int id;
	private Product product;

	public Order() {
	}

	public Order(int id, Product product) {
		this.id = id;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Product: " + product;
	}
}
