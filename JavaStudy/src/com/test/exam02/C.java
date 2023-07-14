package com.test.exam02;

public class C {

    private int i;
    private int j;
    private int k;

    public C(){}    // 기본 생성자 default constructor
                    // 다른 생성자를 개발자가 만들어 주면 기본 생성자(인자가 없는 생성자)가 자동으로 생성이 안됨...

    public C(int i){    // 생성자의 인자 형태에 따라 각각 다른 내용의 실행 구문을 만들어 줄 수 있음.
        this.i = i;
        System.out.println("C클래스 i = " + this.i);
    }

    public C(int j, int k){

        this.j = j;
        this.k = k;
        System.out.println("C클래스 j = " + this.j);
        System.out.println("C클래스 k = " + this.k);

    }

    public void ccc(int i){
        System.out.println("인자가 하나!!!");
    }

    public void ccc(int i, int j){
        System.out.println("인자가 둘!!!");
    }

}
