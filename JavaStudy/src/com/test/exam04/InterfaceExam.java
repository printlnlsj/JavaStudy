package com.test.exam04;

interface SalesPlanInterface {    // 완전한 설계도(요약)
    public void manager();
    public void goal();
    public void product();
}

class A1Team implements SalesPlanInterface{

    @Override
    public void manager() {
        System.out.println("A팀장 : 맹구");
    }

    @Override
    public void goal() {
        System.out.println("A팀 판매 목표 70억 달성");
    }

    @Override
    public void product() {
        System.out.println("A팀 주력 상품 : TV");
    }
}

public class InterfaceExam{
    public static void main(String[] args) {
        A1Team a1team = new A1Team();

        a1team.manager();
        a1team.goal();;
        a1team.product();
    }
}
