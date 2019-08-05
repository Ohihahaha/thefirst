package com.Tech.bean;

public class Order {
	private int id;
	private int tableNum;
	private int realPeople;
	private double totalPrice;
	private double ssPrice;
	private double cjPrice;
	private String menus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRealPeople() {
		return realPeople;
	}
	public void setRealPeople(int realPeople) {
		this.realPeople = realPeople;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getSsPrice() {
		return ssPrice;
	}
	public void setSsPrice(double ssPrice) {
		this.ssPrice = ssPrice;
	}
	public double getCjPrice() {
		return cjPrice;
	}
	public void setCjPrice(double cjPrice) {
		this.cjPrice = cjPrice;
	}
	public String getMenus() {
		return menus;
	}
	public void setMenus(String menus) {
		this.menus = menus;
	}
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	

}
