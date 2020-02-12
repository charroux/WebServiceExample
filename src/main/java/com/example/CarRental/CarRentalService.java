package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
public class CarRentalService {

	private List<Car> cars = new ArrayList<Car>();

	@Autowired
	CarRepository carRepository;

	public CarRentalService(){
		cars.add(new Car("AA1122", "Ferrari", 1000));
		cars.add(new Car("BB22CC", "Peugeot", 1000));
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
		carRepository.save(car);
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Car getCar(@PathVariable(value = "plateNumber") String plateNumber){
		Car car = cars.stream().filter(c -> c.getPlateNumber().equals("plateNumber")).findFirst().orElse(null);
		return car;
		/*for(Car car: cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		return null;*/
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
