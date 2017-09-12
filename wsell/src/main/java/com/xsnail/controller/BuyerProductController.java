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
    public ResultVO list(){
//        List<ProductCategory> productCategoryList = categoryService.findAll();
//        List<ProductVO> productVOList = new ArrayList<>();
//        for(ProductCategory productCategory : productCategoryList){
//            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
//            ProductVO productVO = new ProductVO();
//            productVO.setCategoryName(productCategory.getCategoryName());
//            productVO.setCategoryType(productCategory.getCategoryType());
//            List<ProductInfo> productInfoList = productService.findUpAll();
//            for(ProductInfo productInfo : productInfoList){
//                ProductInfoVO productInfoVO = new ProductInfoVO();
//                productInfoVO.setProductDesc(productInfo.getProductDescription());
//                productInfoVO.setProductIconUrl(productInfo.getProductIcon());
//                productInfoVO.setProductId(productInfo.getProdcutId());
//                productInfoVO.setProductName(productInfo.getProductName());
//                productInfoVO.setProductPrice(productInfo.getProductPrice());
//                productInfoVOList.add(productInfoVO);
//            }
//            productVO.setCategoryProductList(productInfoVOList);
//            productVOList.add(productVO);
//        }
//        return new ResultVO();

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
