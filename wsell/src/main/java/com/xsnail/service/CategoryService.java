package com.xsnail.service;

import com.xsnail.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
