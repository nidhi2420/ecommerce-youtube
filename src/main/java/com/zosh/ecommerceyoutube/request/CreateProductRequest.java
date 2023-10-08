package com.zosh.ecommerceyoutube.request;

import java.util.HashSet;
import java.util.Set;

import com.zosh.ecommerceyoutube.model.Size;

public class CreateProductRequest {

	private String title;
	private String description;
	private int price;
	
	private int discountedPrice;
	
	private int discountPresent;
	
	private int quantity;
	
	private String brand;
	
	private String color;
	private Set<Size> size = new HashSet<>();
	
	private  String topLevelCategory;
	private  String secondLevelCategory;
	private  String thirdLevelCategory;
	private String imageUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public int getDiscountPresent() {
		return discountPresent;
	}
	public void setDiscountPresent(int discountPresent) {
		this.discountPresent = discountPresent;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Set<Size> getSize() {
		return size;
	}
	public void setSize(Set<Size> size) {
		this.size = size;
	}
	public String getTopLevelCategory() {
		return topLevelCategory;
	}
	public void setTopLevelCategory(String topLevelCategory) {
		this.topLevelCategory = topLevelCategory;
	}
	public String getSecondLevelCategory() {
		return secondLevelCategory;
	}
	public void setSecondLevelCategory(String secondLevelCategory) {
		this.secondLevelCategory = secondLevelCategory;
	}
	public String getThirdLevelCategory() {
		return thirdLevelCategory;
	}
	public void setThirdLevelCategory(String thirdLevelCategory) {
		this.thirdLevelCategory = thirdLevelCategory;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public CreateProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateProductRequest(String title, String description, int price, int discountedPrice, int discountPresent,
			int quantity, String brand, String color, Set<Size> size, String topLevelCategory,
			String secondLevelCategory, String thirdLevelCategory, String imageUrl) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPresent = discountPresent;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.topLevelCategory = topLevelCategory;
		this.secondLevelCategory = secondLevelCategory;
		this.thirdLevelCategory = thirdLevelCategory;
		this.imageUrl = imageUrl;
	}
    
	
	
}
