
package org.example.service;

import org.example.dto.CarDTO;
import org.example.entity.Category;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;
    private final CategoryService categoryService;

    public CarService(CarRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public String addCars(CarDTO dto) {
        if (!dto.getName().isBlank() && dto.getName().length() > 3) {
            Car car = new Car();
            car.setCarName(dto.getName());
            car.setYear(dto.getYear());

            Category category = categoryService.getCategoryById(dto.getCategory());
            car.setCategory(category);

            repository.save(car);
        }
        return "ADDED";
    }

    public List<Car> getAllCars() {
        return repository.findAll();
    }
}
