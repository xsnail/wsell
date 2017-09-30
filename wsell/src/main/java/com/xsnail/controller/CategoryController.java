package com.xsnail.controller;

import com.xsnail.dataobject.ProductCategory;
import com.xsnail.dataobject.ProductInfo;
import com.xsnail.enums.ResultEnum;
import com.xsnail.exception.SellException;
import com.xsnail.form.CategoryForm;
import com.xsnail.service.CategoryService;
import com.xsnail.util.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
@RequestMapping("/seller/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(){
        Map<String,Object> map = new HashMap();
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("categoryList",productCategoryList);
        return new ModelAndView("category/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(Integer categoryId){
        Map<String,Object> map = new HashMap<>();
        if(categoryId != null){
//            ProductInfo productInfo = productService.findOne(categoryId);
//            if(productInfo != null) {
//                map.put("productInfo", productInfo);
//            }
            ProductCategory category = categoryService.findOne(categoryId);
            if(category != null){
                map.put("category",category);
            }
        }
        return new ModelAndView("/category/index",map);
    }


    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", ResultEnum.PARAM_ERROR.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        try{
            ProductCategory productCategory = new ProductCategory();
            BeanUtils.copyProperties(categoryForm,productCategory);
            categoryService.save(productCategory);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }
        return new ModelAndView("redirect:/seller/category/list");
    }
}
