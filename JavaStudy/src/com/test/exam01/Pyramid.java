package com.test.exam01;

public class Pyramid {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("\n왼쪽에서 오른쪽으로 *이 하나씩 증가\n");

        for(int i=0; i<num; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
