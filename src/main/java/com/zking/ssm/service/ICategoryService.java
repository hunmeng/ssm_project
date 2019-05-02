package com.zking.ssm.service;

import com.zking.ssm.model.Category;

import java.util.List;

public interface ICategoryService {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> listCategory(Category category);
}