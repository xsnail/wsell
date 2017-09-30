package com.xsnail.controller;

import com.xsnail.dataobject.ProductCategory;
import com.xsnail.dataobject.ProductInfo;
import com.xsnail.service.CategoryService;
import com.xsnail.service.ProductService;
import com.xsnail.util.ResultVOUtil;
import com.xsnail.vo.ProductInfoVO;
import com.xsnail.vo.ProductVO;
import com.xsnail.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "123")
    public ResultVO list(){
        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = new ArrayList<>();
        for(ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType() == productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductIconUrl(productInfo.getProductIcon());
                    productInfoVO.setProductDesc(productInfo.getProductDescription());
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setCategoryProductList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
