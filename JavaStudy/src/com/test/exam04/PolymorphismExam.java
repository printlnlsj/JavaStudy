package com.test.exam04;

class Family{
    public void hello(){
        //System.out.println("가족들과 인사합시다."); --> 실행을 안함. --> 가상 메소드화 시킴.
    }
}

class KimFamily extends Family{
    @Override
    public void hello(){
        System.out.println("김선생님 안녕하세요?");
    }
    void dinner(){
        System.out.println("같이 식사나 한번 하시죠.");
    }
    void drink(){
        System.out.println("술 한잔 하시죠.");
    }
}

class ParkFamily extends Family{
    @Override
    public void hello(){
        System.out.println("박선생님 안녕하세요?");
    }
}

public class PolymorphismExam {
    public static void main(String[] args) {
        Family f;   // 선언만 함
        f = new KimFamily();
        f.hello();
        
        f = new ParkFamily();
        f.hello();
    }
}
