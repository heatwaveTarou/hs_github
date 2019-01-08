package model;

import java.io.Serializable;

public class Item implements Serializable{

	private int id;
	private String name;
	private String size;
	private String textur;
	private String photo;
	private String explan;
	private int stock;
	private int price;

	public Item() {}
	public Item(int id, String name, String size, String textur, String photo, String explan, int stock, int price) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.textur = textur;
		this.photo = photo;
		this.explan = explan;
		this.stock = stock;
		this.price = price;
	}
	public int getId() {return id;}
	public String getName() {return name;}
	public String getSize() {return size;}
	public String getTextur() {return textur;}
	public String getPhoto() {return photo;}
	public String getExplan() {return explan;}
	public int getStock() {return stock;}
	public int getPrice() {return price;}
}
