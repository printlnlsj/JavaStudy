package com.test.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface    // Annotation
interface MyLambdaFunction{
    int sum(int a, int b);
}

@FunctionalInterface
interface MyPrint{
    String printLambda();
}

public class LambdaExam {
    public static void main(String[] args) {
        
        // 2개의 인자를 받아서 계산 후 반환하는 함수를 람다 표기법으로 생성
        MyLambdaFunction myLambdaFunction = (int a, int b) -> a + b;
        System.out.println("myLambdaFunction.sum(3, 5) = " + myLambdaFunction.sum(3, 5));
    
        // 인자 없이 결과값을 반환하는 함수를 람다 표기법으로 생성
        MyPrint myPrint = () -> "Hello World";
        System.out.println("myPrint.printLambda() = " + myPrint.printLambda());

        // 1. Supplier : 매개변수 없이 반환값만 갖는 함수형 인터페이스 사용
        Supplier<String> supplier = () -> "안녕하세요!!";
        System.out.println("supplier.get() = " + supplier.get());

        // 2. Consumer : 객체 T를 매개변수로 받아서 사용하고 반환값은 없는 함수형 인터페이스 사용
        Consumer<String> consumer = (s) -> System.out.println(s.split(" ")[0]);
        consumer.accept("안녕하세요? 반갑습니다."); // 만든 함수를 사용해서 실행
        consumer.andThen(System.out::println).accept("날씨가 좋네요");    // 메소드 참조에 대한 람다 표기법

        // 3. Function : 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스 사용
        // Function<T,R>
        Function<String,Integer> function = s -> s.length();    // 함수 생성 
        System.out.println("function.apply(\"Hello World\") = " + function.apply("Hello World"));

        // 4. Predicate : 객체 T를 매개변수로 받아 처리한 후 Boolean으로 반환
        Predicate<String> predicate = (s) -> s.equals("Hello World");    // 함수 생성
        System.out.println("predicate.test(\"Hello My World\") = " + predicate.test("Hello My World"));

    }
}
