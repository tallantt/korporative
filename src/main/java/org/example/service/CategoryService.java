package org.example.service;

import org.example.dto.CategoryDTO;
import org.example.entity.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public String addCategory(CategoryDTO dto) {
        try {
            Category category = new Category();
            category.setName(dto.getName());
            category.setModel(dto.getModel());
            repository.save(category);
        } catch (Exception e) {
            return "NOT ADDED" + e.getMessage();
        }
        return "ADDED";
    }

    public List<Category> getAllCategory(){
        return repository.findAll();
    }

    public Category getCategoryById(long id) {
        return repository.getById(id);
    }
}