package com.test.exam03;

public class Member {   // DTO(Data Transfer Object)

    private String userid;
    private String username;
    private int age;

    public Member(){}
    public Member(String userid, String username, int age){ // overloading
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    
    // getter method
    public String getUserid(){
        return this.userid;
    }

    public String getUsername(){
        return this.username;
    }

    public int getAge(){
        return this.age;
    }

    // setter method
    public void setUserid(String userid){
        this.userid = userid;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setAge(int age){
        this.age = age;
    }


    static class Builder{   // 내부 클래스

        private String userid;
        private String username;
        private int age;

        public Builder userid(String userid){
            this.userid = userid;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Member build(){
            
            if(userid == null || username == null || age == 0)
                throw new IllegalStateException("Cannot create Member");
            
            return new Member(userid, username, age);
        }

    }

}
