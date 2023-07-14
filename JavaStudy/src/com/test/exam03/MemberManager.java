package com.test.exam03;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {

    public static void main(String[] args) {
        
        List<Member> list = new ArrayList<>();
        
        /* 
        list.add(new Member("mylover","김현주", 23));
        list.add(new Member("mydarling","김철수", 24));
        list.add(new Member("mybaby","김현진", 25));
        */

        list.add(new Member.Builder()   // Builder 패턴
            .userid("mylover")
            .username("손미주")
            .age(23)
            .build()
        );
        list.add(new Member.Builder()   // Builder 패턴
            .userid("mydarling")
            .username("김기수")
            .age(24)
            .build()
        );
        list.add(new Member.Builder()   // Builder 패턴
            .userid("mybaby")
            .username("하현진")
            .age(25)
            .build()
        );

        for(Member member: list){
            System.out.println("userid = " + member.getUserid());
            System.out.println("username = " + member.getUsername());
            System.out.println("age = " + member.getAge());
        }

        list.stream().map(n->n.getUsername()).sorted().forEach(s->System.out.println(s));
        
    }
    
}
