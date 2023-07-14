package com.test.exam02;

public class A {

    int a = 1; // 멤버 변수
    int b = 2; // 멤버 변수

    public A(){}    // 기본 생성자가 컴파일시 자동으로 소스에 삽입이 됨...

    public int sum(int i, int j){ // 메소드(method) --> 함수
        return i+j;
    }
}