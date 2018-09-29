package com.xsnail.mapper;

import com.xsnail.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.JDBCType;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public interface ProductCategoryMapper {

    @Select("select *from product_category")
    List<ProductCategory> findAll();

    @Select("select *from product_category where categoryId = #{categoryId}")
    ProductCategory findOne(Integer categoryId);

    @Insert("insert into product_category values(   )")
    ProductCategory save(ProductCategory productCategory);
}
