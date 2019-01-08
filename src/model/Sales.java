package model;

import java.io.Serializable;

public class Sales implements Serializable{

	private String acoount;
	private int id;
	private int price;
	private int counts;
	private String date;

	public Sales() {}
	public Sales(String acoount, int id, int price, int counts, String date) {
		this.acoount = acoount;
		this.id = id;
		this.price = price;
		this.counts = counts;
		this.date = date;
	}
	public String getAcoount() {return acoount;}
	public int getId() {return id;}
	public int getPrice() {return price;}
	public int getCounts() {return counts;}
	public String getDate() {return date;}
}
