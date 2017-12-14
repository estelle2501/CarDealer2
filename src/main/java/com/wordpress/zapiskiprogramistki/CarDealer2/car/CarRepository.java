package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.data.repository.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

interface CarRepository extends Repository<Car, Integer> {
	Car save(Car car);
	Car findOne(Integer id);
    void delete(Integer id);
    Page<Car> findAll(Pageable pageable);

    default Car findOneOrThrow(Integer id){
    	Car car = findOne(id);
        if(car == null) {
            throw new CarNotFoundException(id.toString());
        }
        return car;
    }

}
