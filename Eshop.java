package eshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Eshop {

	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	private int nextProductId = 1;
	private int nextOrderId = 1;

	private List<Product> products = new ArrayList<Product>();
	private List<Order> orders = new ArrayList<Order>();

	public static void main(String[] args) throws Exception {
		Eshop eshop = new Eshop();
		eshop.mainMenu();
	}

	private void mainMenu() throws Exception {
		while (true) {
			System.out.println("================");
			System.out.println("Welcome to Eshop");
			System.out.println("1. Add a new product");
			System.out.println("2. Remove existing product");
			System.out.println("3. List all products");
			System.out.println("4. Order a product");
			System.out.println("5. List all orders");
			System.out.println("6. Exit");
			System.out.print("Enter your choice (1-6): ");
			int choice = Integer.parseInt(input.readLine());

			switch (choice) {
			case 1:
				addNewProduct();
				break;
			case 2:
				removeExistingProduct();
				break;
			case 3:
				listAllProducts();
				break;
			case 4:
				orderProduct();
				break;
			case 5:
				listAllOrders();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Your choice is not in range (1-6), try again.");
				break;
			}
		}
	}

	private void addNewProduct() throws Exception {
		System.out.println("================");
		System.out.print("Enter product name: ");
		String name = input.readLine();
		System.out.print("Enter product description: ");
		String description = input.readLine();
		System.out.print("Enter product price: ");
		int price = Integer.parseInt(input.readLine());

		Product product = new Product(nextProductId, name, description, price);
		products.add(product);
		nextProductId++;
		System.out.println("Added new product: " + product.toString());
	}

	private void removeExistingProduct() throws Exception {
		System.out.println("================");
		System.out.print("Enter product id: ");
		int id = Integer.parseInt(input.readLine());

		int productIndex = -1;
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);

			if (product.getId() == id) {
				productIndex = i;
				break;
			}
		}

		if (productIndex == -1) {
			System.out.println("Product with given id not found.");
		} else {
			products.remove(productIndex);
			System.out.println("Product removed.");
		}
	}

	private void listAllProducts() {
		System.out.println("================");
		System.out.println("Products:");
		for (Product product : products) {
			System.out.println(product);
		}
	}

	private void orderProduct() throws Exception {
		System.out.println("================");
		System.out.print("Enter product id: ");
		int id = Integer.parseInt(input.readLine());

		for (Product product : products) {
			if (product.getId() == id) {
				Order order = new Order(nextOrderId, product);
				orders.add(order);
				nextOrderId++;
				System.out.println("Product ordered: " + order);
				break;
			}
		}
	}

	private void listAllOrders() {
		System.out.println("================");
		System.out.println("Orders:");
		for (Order order : orders) {
			System.out.println(order);
		}
	}
}
