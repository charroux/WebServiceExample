package com.example.CarRental;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;

@Entity
public class CarSQL {

	@javax.persistence.Id
	private String plateNumber;
	private String brand;
	private int price;

	@Transient
	private ArrayList<Dates> dates = new ArrayList<Dates>();

	public CarSQL() {
		super();
	}

	public CarSQL(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
	}

	public ArrayList<Dates> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Dates> dates) {
		this.dates = dates;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
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

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}
