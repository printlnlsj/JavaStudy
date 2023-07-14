package com.test.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExam {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("Java");
        list1.add("World");

        // 1. ifPresent() --> 실행구문에서 null이 발생하면 실행되지 않도록 함.
        Optional<List<String>> optional1 = Optional.of(list1);
        optional1.ifPresent(s->System.out.println(s));

        List<String> list2 = null;
        //System.out.println(list2.get(0));
        Optional<List<String>> optional2 = Optional.ofNullable(list2);
        optional2.ifPresent(s->System.out.println(s.get(0)));


        // 2. isPresent() --> Optional 객체의 값이 null이거나 false 값이 발생되면 false값을 반환, 아니면 true
        System.out.println(Optional.of("TEST").isPresent());    // Optional 객체에 값이 있으니까 true 리턴
        System.out.println(Optional.ofNullable(null).isPresent());    // Optional 객체에 null이 들어오니까 false 리턴
        System.out.println(Optional.of("TEST").filter(v->"EST".equals(v)).isPresent());    // Optional 객체에 false값이 생성되기 때문에 false 리턴


        // 3. orElse() --> 값이 존재하면 값을 리턴하고, 그렇지 않으면 orElse()내의 인자값을 리턴
        String a = "ABCD";
        String result, result2;
        Optional<String> optional3 = Optional.ofNullable(a);
        result = optional3.filter(s->s.startsWith("AB")).orElse("AB로 시작하는 값이 없어요");
        System.out.println(result);
        result2 = optional3.filter(s->s.startsWith("X")).orElse("AB로 시작하는 값이 없어요");
        System.out.println(result2);


        // 4. map()
        System.out.println(Optional.of("XYZ").map(String::toLowerCase).orElse("오류 발생"));


    }
}
