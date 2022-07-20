package com.ll.exam.test0719;

public class Fibonacci {
        /*
        피보나치 수열에서 5천만 이하이면서 짝수인 항의 합은 얼마인가요?(인텔리제이 사용가능, 정답에 숫자만 입력)
        피보나치(Fibonacci) 수열의 각 항은 바로 앞의 항 두 개를 더한 것입니다.
         1과 2로 시작하는 경우 이 수열은 아래와 같습니다.
         1 , 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
         5천만 이하의 짝수 값을 갖는 모든 피보나치 항을 더하면 얼마가 됩니까?
         */


    static int initsize=100; // 초기 사이즈
    static int [] fibo = new int [initsize+1];

    public static void main(String[] args) {
       // int a = getFiboSize(10);
      //  System.out.println(SumEvenfibo(a));
        int n = getFiboSize(50000000);
        System.out.println(SumEvenfibo(n));

    }

    static int SumEvenfibo(int n){

        int sum=0;
        //System.out.printf("sum : ");
        for(int i=1;i<n+1;i++){
            if(fibo[i]%2==0) {
                sum+=fibo[i];
              //  System.out.printf(fibo[i]+"+");
            }
        }
       // System.out.println();
        return sum;
    }

    static int getFiboSize(int max){

        fibo[0]=0; fibo[1]=1;
        int n=fibo.length;
        for(int i=2;i<n+1;i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
            if(fibo[i]>max){
                n=i-1;
                break;
            }
        }
       // System.out.println("fibo["+n+"] : "+fibo[n]);
       // System.out.println("fibo["+(n+1)+"] : "+fibo[n+1]);

        return n;
    }
}
