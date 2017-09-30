//package com.xsnail.aspect;
//
//import com.xsnail.constant.CookieConstant;
//import com.xsnail.constant.RedisConstant;
//import com.xsnail.exception.SellException;
//import com.xsnail.exception.SellerAuthorizeException;
//import com.xsnail.util.CookieUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by Administrator on 2017/9/15 0015.
// */
//@Aspect
//@Component
//public class SellerAuthorizeAspect {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Pointcut("execution(public * com.xsnail.controller.Seller*.*(..))"+
//    "&& !execution(public * com.xsnail.controller.SellerUserController.*(..))")
//    public void verify(){
//
//    }
//
//    @Before("verify()")
//    public void doVerify(){
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if(cookie == null){
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis里查
//        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
//        if(StringUtils.isEmpty(tokenValue)){
//            throw new SellerAuthorizeException();
//        }
//
//    }
//}
