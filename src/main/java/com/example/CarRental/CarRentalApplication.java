package com.example.CarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);

		CarRepository carRepository = (CarRepository)context.getBean("carRepository");

		Car car = new Car("11AA22", "Lamborgini", 1000);
		carRepository.save(car);


	}
}
