package com.test.thread;

public class ThreadExam3 {
    public static void main(String[] args) throws InterruptedException {
        
        new Thread(new Runnable() {     // 비동기 처리 부분

            @Override
            public void run() {
            
                for(int i=0; i<10; i++){

                    try {   // 비동기는 throws로 못 던짐
                        Thread.sleep(1000); // 실행 시간 지연, 1초 -> 1000msec
                        System.out.println("Hello 강백호 !!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();    // 화면에 에러 출력 해주는 메소드
                    }    
                
                }

            }
            
        }).start();

        for(int i=0; i<10; i++){    // 동기 처리 부분
            Thread.sleep(1000);
            System.out.println("Hello 송태섭 !!!");
        }
        
        for(int i=0; i<10; i++){    // 동기 처리 부분
            Thread.sleep(1000);
            System.out.println("Hello 정대만 !!!");
        }

    }
}
