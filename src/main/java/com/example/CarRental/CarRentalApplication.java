package com.example.CarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);

		CarRepository carRepository = (CarRepository)context.getBean("carRepository");

		Car car = new Car("22CC33", "Peugeot", 1000);
		Dates date = new Dates();
		date.setDebut("10/10/2022");
		date.setFin("10/11/2022");
		car.getDates().add(date);
		carRepository.save(car);


	}
}
