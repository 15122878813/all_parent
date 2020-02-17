package com.toec.collection.aspect;

import com.toec.common.annotation.CacheGet;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AopByMe {

    @Autowired
    private RedisTemplate redisTemplate;
    @Around(value = "@annotation(com.toec.common.annotation.CacheGet)")
    public Object arount(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        System.out.println("方法前");
        //先获取key,如果注解中没有设置，则自行设置
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CacheGet annotation = signature.getMethod().getAnnotation(CacheGet.class);
        String key = annotation.key();
        if(null == key){
            key = "annotationKey";
        }
        try {
            if(redisTemplate.hasKey(key)){
                //在缓存中存有
                System.out.println("走缓存");
                proceed = redisTemplate.opsForValue().get(key);
                return proceed;
            }else{
                //在缓存中没有
                System.out.println("走数据库");
                proceed = joinPoint.proceed();
                if(annotation.seconds() > 0){
                    //设置过期时间
                    redisTemplate.opsForValue().set(key,proceed,10, TimeUnit.DAYS);
                }else{
                    //不设置过期时间
                    redisTemplate.opsForValue().set(key,proceed);
                }
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
        return proceed;
    }
}