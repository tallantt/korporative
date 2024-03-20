
package org.example.controller;

import org.example.aspect.ToLog;
import org.example.dto.CategoryDTO;
import org.example.dto.CarDTO;
import org.example.dto.UserDTO;
import org.example.entity.Category;

import org.example.entity.Car;
import org.example.service.CarService;
import org.example.service.CategoryService;

import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final CarService carService;
    private final CategoryService categoryService;
    private final UserService userService;
    public HomeController(CarService carService, CategoryService categoryService, UserService userService){
        this.categoryService=categoryService;
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping
    public String getHome() {
        return "Hello Welcome Home!";
    }
    @ToLog
    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        return "hello welcome "+name+"!!!";
    }

    @PostMapping("/car")
    public String addCars(@RequestBody CarDTO carDTO) {
        return carService.addCars(carDTO);
    }
    @ToLog
    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/category")
    public String addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }
    @ToLog
    @PostMapping("/user")
    public String addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
}
