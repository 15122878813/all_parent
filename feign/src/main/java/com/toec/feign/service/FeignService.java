package com.toec.feign.service;

import com.toec.common.vo.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "vip",fallback = FeignServiceFb.class)
//当发生降级时，将使用降级类中的方法进行返回
public interface FeignService {
    @GetMapping("/doFindVipCenter")
    JsonResult doFindVipCenter(@RequestParam String userName);
}
