package com.zosh.ecommerceyoutube.request;

public class AddItemrequest {

	private Long ProductId;
	private String size;
	private int quantity;
	private Integer price;
	
	public AddItemrequest() {
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public AddItemrequest(Long productId, String size, int quantity, Integer price) {
		super();
		ProductId = productId;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}
	
}
