package com.nrabello.back.service.impl;

import com.nrabello.back.domain.Category;
import com.nrabello.back.service.IFacade;
import com.nrabello.back.strategies.impl.category.FindAllCategoriesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade implements IFacade<Category> {

    @Autowired
    FindAllCategoriesStrategy findAllCategoriesStrategy;

    @Override
    public List<Category> findAll() {
        return findAllCategoriesStrategy.process(new Category());
    }

}
