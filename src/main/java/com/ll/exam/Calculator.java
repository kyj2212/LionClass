package com.ll.exam;

public class Calculator {

    static int result;

    public static void main(String[] args) {
        plus(10,20);
        // 출력 => 결과 : 30

        plus(50,20);
        // 출력 => 결과 : 70

        substract(50,20);
        // 출력 => 결과 : 30

        substract(5,2);
        // 출력 => 결과 : 3

        multiply(5,2);
        // 출력 => 결과 : 10


    }


    static int plus(int a, int b){
        System.out.println("result : "+ (result=a+b));
        return result ;
    }
    static int substract(int a, int b){
        result = a-b;
        System.out.println("result : "+result);
        return result;
    }
    static int multiply(int a, int b){
        result = a*b;
        System.out.println("result : "+result);
        return result;
    }
    static int divide(int a, int b){
        result = a/b;
        System.out.println("result : "+result);
        return result;
    }



}

