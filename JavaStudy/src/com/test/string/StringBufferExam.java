package com.test.string;

public class StringBufferExam {
    
    /*
     * StringBuffer는 멀티스레드 환경에서 안전.
     * StringBuilder는 성능면에서 StringBuffer보다 좋음.
     * 따라서, 동기/비동기 이런거 따질 필요가 없는 상황에선 StringBuilder를 권장.
     * 비동기 상황에선 StringBuffer를 권장.
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("My World");
        System.out.println(sb);
        sb.insert(0, "Everyone ");
        System.out.println(sb);
        System.out.println(sb.substring(0,8));  // 0번째부터 8번째까지
    }
}
