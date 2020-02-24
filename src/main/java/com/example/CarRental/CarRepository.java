package com.example.CarRental;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,String> {

    public Car findByPrice(int price);

}
