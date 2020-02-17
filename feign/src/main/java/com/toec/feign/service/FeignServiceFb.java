package com.toec.feign.service;

import com.toec.common.vo.JsonResult;
import org.springframework.stereotype.Service;

@Service
public class FeignServiceFb implements FeignService {
    @Override
    public JsonResult doFindVipCenter(String userName) {
        return new JsonResult("后台服务处理失败");
    }
}
