package com.test.thread;

class ExamClass1 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread가 시작");
    }
}

public class ThreadExam2 {
    public static void main(String[] args) {
        ExamClass1 examClass1 = new ExamClass1();
        examClass1.start();
    }
}
