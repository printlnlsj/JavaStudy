package com.test.exam02;

public class ClassExam {
    public static void main(String[] args) {
        
        A a = new A(); // 클래스 선언 --> 
                       // a라는 Instance를 생성 --> 
                       // 클래스 참조변수 a(인스턴스 변수 a)안에 A 클래스 형태가 담겨져 있는 메모리 주소가 들어옴
        System.out.println("a.a = " + a.a);
        int result = a.sum(10, 20);
        System.out.println("result = " + result);
        System.out.println("result = " + a.sum(20, 30));

        a.a = 5;
        System.out.println("a.a = " + a.a);

        A a1 = new A(); // a1 인스턴스를 생성
        System.out.println("a1.a = " + a1.a); 

        B b = new B();
        System.out.println("b.getA() = " + b.getA());
        b.setB(100);
        System.out.println("b.b = " + b.getB());

        new C(20);  // 익명 클래스
        new C(30, 40);

        C c = new C();
        c.ccc(0);
        c.ccc(0,0);

        D.ddd();    // ddd는 static method - 별도의 인스턴스 만들 필요 없음

        D d1 = new D(); // d1 인스턴스
        D d2 = new D(); // d2 인스턴스

        d1.d = 4;
        System.out.println("d2.d = " + d2.d);   // 다른 인스턴스여도 값을 공유할 수 있다

        d1.e = 23;
        System.out.println("d2.e = " + d2.e);   // 초기화를 안해줘서 결과 : 0

    }
}
