package com.test.string;

import java.util.ArrayList;

public class StringBuilderExam {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();  // 여러개의 문자열을 연결하는데 특화된 객체
        stringBuilder.append("문자열1").append("문자열2");
        // String str = "문자열1" + "문자열2" 랑 같은 말. 위에걸 많이 씀.
        
        // StringBuilder를 string으로 변환하기 위해서는 반드시 toString() 메소드로 이용
        String str = stringBuilder.toString();  
        
        System.out.println(stringBuilder);
        System.out.println(str);

        ArrayList<String> list = new ArrayList<>();
        list.add("첫번째");
        list.add("두번째");
        list.add("세번째");

        for(int i=0; i<list.size(); i++){
            stringBuilder.append(list.get(i));
        }

        System.out.println(stringBuilder);
    }
}
