package com.test.exam04;

public class AbstractClassExam {    // 기존 클래스 + 설계도
    public static void main(String[] args) {
        
        ATeam ateam = new ATeam();

        ateam.companyGoal();
        ateam.manager();
        ateam.departGoal();;
        ateam.product();

    }
}

abstract class SalesPlan{

    public void companyGoal(){
        System.out.println("2023년 전사 목표 300억 달성");
    }
    abstract public void departGoal();  // 추상 메소드(abstract method)
    abstract public void product(); // 추상 메소드(abstract method)

}

class ATeam extends SalesPlan{

    public void manager(){
        System.out.println("A팀장 : 짱구");
    }

    @Override
    public void departGoal() {
        System.out.println("A팀 판매 목표 70억 달성");
    }

    @Override
    public void product() {
        System.out.println("A팀 주력 상품 : TV");
    }

}

class BTeam extends SalesPlan{

    public void manager(){
        System.out.println("B팀장 : 철수");
    }

    @Override
    public void departGoal() {
        System.out.println("B팀 판매 목표 100억 달성 !!");
    }

    @Override
    public void product() {
        System.out.println("B팀 주력 상품 : 냉장고");
    }

}