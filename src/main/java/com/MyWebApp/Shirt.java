package com.MyWebApp;

//get the values in postman application:
public class Shirt {
	private String brand;
	private int price;
	private String colour;
	private boolean isChecked;
	private int size;

	public Shirt(String brand, int price, String colour, boolean isChecked, int size) {
		this.brand = brand;
		this.price = price;
		this.colour = colour;
		this.isChecked = isChecked;
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
