package com.zensar.dto;

public class Stock {

    private int id;
	private String name;
    private String market;
    private int price;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Stock(int id, String name, String market, int price) {
        this.id = id;
        this.name = name;
        this.market = market;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Stock [id=" + id + ", market=" + market + ", name=" + name + ", price=" + price + "]";
    }
    public Stock() {
    }
    

}
