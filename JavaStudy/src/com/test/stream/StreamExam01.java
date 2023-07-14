package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExam01 {
    
     /*

     *** stream API 정의 및 등장 배경
     - 자바에서는 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션(Collect Framework)을 사용
     - 이렇게 저장된 데이터에 접근하기 위해서는 반복문이나 반복자를 사용하여 매번 새로운 코드를 
       작성해야 함. 이렇게 작성된 코드는 길이가 같고 가독성이 떨어지며, 코드의 재사용이 불가능
     - 즉, 데이터베이스의 쿼리와 같이 정형화된 처리 패턴을 가지지 못했기에 데이터마다 다른 방법으로
       접근해서 작업을 했음. 이러한 문제점을 극복하기 위해 Java SE 8부터 함수형 프로그램의 특성을
       가진 stream이라는 API(객체)를 도입.
     - 스트림 API는 정형적인 데이터 읽기/쓰기 메소드 제공함으로 반복된 프로그램 작업 없이
       비교적 수월하게 프로그램을 작성할 수 있음.

     */
    
     /*
    
     *** stream API의 특성
     1. 데이터 접근해서 읽고/쓰기/수정에 최적화된 메소드를 제공
     2. 스트림은 재사용이 가능한 컬렉션과 달리 단 한 번만 사용. --> 재사용 불가 
     3. 스트림은 원본 데이터를 변경하지 않음.
     4. 스트림 연산은  filter-map 기반의 API를 사용하여 lazy 연산을 통해 성능을 최적화
     5. 스트림 연산은 병렬 처리를 지원.

     *** stream API 동작 흐름
     데이터 소스 --> 스트림 생성 --> 중개연산(필터) --> 중개연산(맵) --> 최종연산(출력)
     
     */
    
    
    public static void main(String[] args) {
    
    // 스트림 API 예제
    // 1 ~ 10까지의 점수를 갖는 List에서 6보다 작고 짝수인 요소를 찾아 10배 시킨 리스트를 출력
        
        /* 
         List<Integer> list = new ArrayList<>();
         for(int a:list)
            list.add(a);
         밑에 줄이랑 똑같은 말
        */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);   // 1. 데이터 소스 생성
        
        // 제일중요!!!
        list.stream()   // 2. 스트림 생성
            .filter(i->i<6) // 3. 필터 연산 : 6보다 작은 값들만 가져옴
            .filter(i->i%2==0)  // 3. 필터 연산 : 짝수값만 가져옴
            .map(i->i*10)   // 4. map 연산 : 가져온 값에다 10을 곱함.
            .collect(Collectors.toList())   // 5. 최종 연산 -->  출력
            .forEach(result->System.out.print(result + "\t"));
    
        

        /*

         ** 스트림 생성
         - 자바에서 제공하는 모든 컬렉션의 최상위 객체가 Collection 객체임.
         - 이 Collection 인터페이스에는 stream() 메소드가 선언되어 있음.
         - 따라서, Collection 인터페이스를 구현한 모든 List와 Set 컬렉션에서도
           stream() 메소드로 스트림을 생성할 수 있음.
         - 그리고, 배열에서도 스트림을 생성할 수 있는데, 이때는 Arrays 클래스를 이용함.
         - 또한, 기본 타입인 int, long, double형에 대한 스트림 생성을 위한
           IntStream, LongStream, DoubleStream 인터페이스가 존재함.

         */

         System.out.println("\n");
         
         // 리스트 객체로부터 스트림 생성
         List<Integer> ll = new ArrayList<>();
         
         ll.add(4);
         ll.add(2);
         ll.add(3);
         ll.add(1);

         Stream<Integer> stream = ll.stream();  // 컬렉션에서 스트림 생성
         stream.forEach(System.out::println);

         
         System.out.println();
         // 배열로부터 스트림 생성
         int[] arr = {1,2,3,4,5,6,7,8,9,10};
         IntStream stream1 = Arrays.stream(arr); // 배열에서 스트림 생성
         stream1.forEach(System.out::println);
    

         System.out.println();
         // 가변 매개변수로부터 스트림 생성
         Stream<Double> stream2 = Stream.of(4.2, 2.5, 3.1, 1.9);
         stream2.forEach(System.out::println);
    


         /*

         ** 스트림 중개 연산
         - 스트림 API에 의해 생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
         - 이러한 중개 연산은 스트림을 전달 받아 스트림을 반환하므로, 중개 연산은 연속으로 연결해서 사용 가능
         - 스트림의 중개 연산은 filter-map 기반의 API를 사용하고 lazy 연산을 통해 성능을 최적화

         1. 스트림 필터링 : filter(), distinct()
         2. 스트림 변환 : map(), flatMap()
         3. 스트림 제한 : limit(), skip()
         4. 스트림 정렬 : sorted()
         5. 스트림 연산 결과 확인 : peek()

          */
        
        System.out.println();
        // 스트림 필터링 : 스트림에서 중복된 요소를 제거하고 홀수만을 골라 내시오.
        IntStream stream3 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
        stream3.distinct().filter(n->n%2!=0).forEach(System.out::println);


        System.out.println();
        // 스트림 변환 : 다음의 문자열들에서 각각의 문자열의 길이를 구해 보시오.
        Stream<String> stream4 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        stream4.map(s->s.length()).forEach(System.out::println); 


        System.out.println();
        // 스트림 변환 : 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환
        String[] str = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> stream5 = Arrays.stream(str);
        stream5.flatMap(s->Stream.of(s.split(" "))).forEach(System.out::println);

        System.out.println();
        // 스트림 제한
        // limit() : 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환
        // skip() : 해당 스트림의 첫 번째 요수부터 전달된 개수만큼을 제외한 나머지 요소만으로 이루어진 새로운 스트림을 반환
        IntStream stream6 = IntStream.range(0, 10);
        IntStream stream7 = IntStream.range(0, 10);
        IntStream stream8 = IntStream.range(0, 10);

        stream6.skip(4).forEach(n->System.out.print(n + " "));
        System.out.println();
        stream7.limit(5).forEach(n->System.out.print(n + " "));
        System.out.println();
        stream8.skip(3).limit(5).forEach(n->System.out.print(n + " "));

        System.out.println("\n");
        // 스트림 정렬
        // 1. 오름차순(Ascending)
        Stream<String> stream9 = Stream.of("Park", "Kim", "Lee", "Choi");
        stream9.sorted().forEach(s->System.out.print(s + " "));

        System.out.println();
        // 2. 내림차순(Descending)
        Stream<String> stream10 = Stream.of("Park", "Kim", "Lee", "Choi");
        stream10.sorted(Comparator.reverseOrder()).forEach(s->System.out.print(s + " "));



        /*
        
        ** 스트림 최종연산
        1. 요소의 출력 : forEach()
        2. 요소의 소모 : reduce() --> 첫 번째와 두 번째 요소를 가지고 연산을 수행한 뒤 
                                     그 결과의 세 번째 요소를 가지고 또 다시 연산을 수행하고 앞서 연산한 내용은 메모리에서 삭제
        3. 요소의 검색 : findFirst(), findAny()
        4. 요소의 검사 : anyMatch(), allMatch(), noneMatch()
        5. 요소의 통계 : count(), min(), max()
        6. 요소의 연산 : sum(), average()
        7. 요소의 수집 : collect() --> 스트림의 요소들을 컬렉션으로 변환

         */

         System.out.println("\n");
        // reduce 메소드를 이용하여 1~10까지의 합 구하기
        Stream<Integer> number1 = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> sum1 = number1.reduce((x,y)-> x + y);
        sum1.ifPresent(s->System.out.println("sum = " + s));

        System.out.println();
        // collect 메소드 --> 스트림 요소들을 Collectors.joining을 사용해서 ,(쉼표)로 구분해서 문자열로 합침.
        Stream<String> fruits = Stream.of("banana", "apple", "mango", "peach");
        //String result = fruits.map(Object::toString).collect(Collectors.joining(","));
        String result = fruits.map(Object::toString).collect(Collectors.toList()).toString();
        System.out.println(result);

        System.out.println();
        // 열거된 문자열중에 a를 포함한 단어를 출력해 보세요.
        Stream<String> stream11 = Stream.of("aa", "b", "c", "ab");
        System.out.println(stream11.filter(n->n.contains("a")).collect(Collectors.joining(",")));
        
        System.out.println();
        // 열거된 문자열을 모두 대문자로 바꿔 보세요.
        Stream<String> stream12 = Stream.of("aa", "b", "c", "ab");
        System.out.println(stream12.map(s->s.toUpperCase()).collect(Collectors.joining(",")));

    }
}
