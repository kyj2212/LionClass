package com.ll.exam.test0719;

public class Multiple3or5 {
    /*
    100000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마인가요?
    (인텔리제이 사용가능, 정답에 숫자만 입력)
    10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
    100000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
     */

    public static void main(String[] args) {
        // System.out.println(getSum3or5(10));
        System.out.println(getSum3or5(100000));
    }

    static long getSum3or5(int n){
        long sum=0;
        for(int i=1;i<n;i++){ // 1~n-1
            if(i%3==0||i%5==0)
                sum+=i;
        }
        return sum;
    }

}
