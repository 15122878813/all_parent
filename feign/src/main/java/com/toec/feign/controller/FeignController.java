package com.toec.feign.controller;

import com.toec.common.vo.JsonResult;
import com.toec.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/url")
    public JsonResult doFindVipCenter(String userName){
        JsonResult jsonResult = feignService.doFindVipCenter(userName);
        return jsonResult;
    };
}
