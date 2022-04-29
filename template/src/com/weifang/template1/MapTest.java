package com.weifang.template1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        HashMap  hashMap = new HashMap<>();
        hashMap.put("hashMap's data",1);
        map.put("map's first data",2);
        map.put("map's second data",hashMap);
        Map<Object, Object> map1 = MapTest.test01(map);
        System.out.println(map1);
    }
    public static Map<Object,Object> test01(Map<Integer,BigInteger> map){
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("success",map);
        return map1;
    }
}
