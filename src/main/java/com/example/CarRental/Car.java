package com.example.CarRental;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.ArrayList;

@Document
@Entity
public class Car {

	@org.springframework.data.annotation.Id
	@javax.persistence.Id
	private String plateNumber;
	private String brand;
	private int price;
	private ArrayList<Dates> dates = new ArrayList<Dates>();
	
	public Car() {
		super();
	}
	
	public Car(String plateNumber, String brand, int price) {
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
