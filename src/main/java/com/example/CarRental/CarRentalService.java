package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {

	private List<Car> cars = new ArrayList<Car>();


	@Autowired
	CarRepository carRepository;

	public CarRentalService() {

		Iterable<Car> allCarJPA = carRepository.findAll();
		for (Car c: allCarJPA) {
			System.out.println(c);
		}

		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Car getCar(@PathVariable(value = "plateNumber") String plateNumber){
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		return null;
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Car rentCar(@PathVariable(value = "plateNumber") String plateNumber,
					   @RequestParam(value = "rent") boolean rent,
					   @RequestBody Dates dates){
		for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				if(rent == true){
					car.getDates().add(dates);
				} else {
					car.getDates().remove(dates);
				}
				return car;
			}
		}
		/*Car c = cars.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst().orElse(null);
		if(rent == true){
			c.getDates().add(dates);
		} else {
			c.getDates().remove(dates);
		}*/
		return null;
	}

}
