package com.test.exam05;

import java.util.*;

import com.test.exam02.B;

public class MapClassTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("userid","mydarling");
        map.put("username","송태섭");

        System.out.println(map.get("userid"));

        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);

        int a = 4;

        Integer a1 = 4;

        String aa = Integer.toString(a);

        String b = "5";
        int t = Integer.parseInt(b);
    }
}
