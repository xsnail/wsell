package com.xsnail.controller;

import com.xsnail.dataobject.User;
import com.xsnail.dto.OrderDTO;
import com.xsnail.enums.ResultEnum;
import com.xsnail.mapper.UserMapper;
import com.xsnail.service.TestService;
import com.xsnail.service.User1Service;
import com.xsnail.service.User2Service;
import com.xsnail.util.ResultVOUtil;
import com.xsnail.vo.AliConfig;
import com.xsnail.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@Controller
@RequestMapping("/ali")
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TestService testService;

    @GetMapping("/getConfig")
    @ResponseBody
    public Object list(){

        AliConfig aliConfig = new AliConfig();
        aliConfig.setMessage("支付宝红包再升级，红包种类更多，金额更大！人人可领，天天可领！长按复制此消息，打开支付宝领红包！04QAnB89AH");
        return aliConfig;
    }


    @GetMapping("/sqlzr")
    @ResponseBody
    public ResultVO sqlzr(String username,String password){
        User user = userMapper.getUser(username,password);
        System.out.println(user.toString());
        return ResultVOUtil.success(user);
    }

    @GetMapping("/testTrans")
    public ResultVO testTrans(){
        testService.testTrans();
        return ResultVOUtil.success();
    }

    @GetMapping("/testTrans2")
    public ResultVO testTrans2(){
        try {
            testService.testTrans2();
            return ResultVOUtil.success();
        }catch (Exception e){
            System.out.println(e.toString());
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(),
                    ResultEnum.PARAM_ERROR.getMessage());
        }
    }

    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    @GetMapping("/testPropagation")
    public void testPropagation(){
        user1Service.addRequired("xhh","123456");
        user2Service.addRequiredExcetion("cqf","123456");
    }

    @GetMapping("/testPropagation2")
    public void testPropagation2(){
        user1Service.addRequired("xhh","123456");
        user2Service.addRequired("cqf","123456");
        throw new RuntimeException();
    }
}
