package com.nrabello.back.service;

import com.nrabello.back.domain.Category;
import com.nrabello.back.strategies.category.FindAllCategoriesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade implements IFacade<Category>{

    @Autowired
    FindAllCategoriesStrategy findAllCategoriesStrategy;

    @Override
    public List<Category> findAll() {
        return findAllCategoriesStrategy.process(new Category());
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> find(String filter) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Long id) {

    }
}
