package com.toec.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static<T> String Seralizable(T object){
            String s = null;
        try{
            s = objectMapper.writeValueAsString(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
    public static<T> T Deseralizable(String json,Class<T> cls){
        T object = null;
        try{
            T o = (T) objectMapper.readValue(json, cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
}
