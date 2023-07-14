package com.test.thread;

class ExamClass implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread가 실행");
    }

}

public class ThreadExam1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ExamClass());
        thread.start();
    }
    
}
