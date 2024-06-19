package com.nrabello.back.strategies.category;

import com.nrabello.back.database.CategoryDao;
import com.nrabello.back.domain.Category;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCategoriesStrategy implements IStrategy<Category> {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> process(Category category) {
        return categoryDao.findAll();
    }
}
