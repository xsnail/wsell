package com.xsnail.service.impl;

import com.xsnail.dataobject.ProductCategory;
import com.xsnail.mapper.ProductCategoryMapper;
import com.xsnail.repository.ProductCategoryRepository;
import com.xsnail.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryMapper.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryMapper.save(productCategory);
    }
}
