package domain;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Product {
	@Id
	@GeneratedValue
	private long id;

	protected String productNumber;
	protected String name;
	protected double price;


	public Product(){}
	public Product(String productNumber, String name, double price) {
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				",name='" + name + '\'' +
				", productNumber='" + productNumber + '\'' +
				", price=" + price +
				'}';
	}
}
