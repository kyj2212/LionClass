package com.ll.exam.test0719;


/*
    1600851475143의 소인수 중에서 가장 큰 수를 구하세요.
    어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고,
    이 소수들을 그 수의 소인수라고 합니다.
    예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.
 */



import java.util.ArrayList;

public class IntegerFactorizaion {

    public static void main(String[] args) {


        //System.out.println(setPrimeFacArr(10));
        //System.out.println(setPrimeFacArr(13195));
       // System.out.println(bigSize(13195L));
        System.out.println(setPrimeFacArr(1600851475143L));

    }

    static boolean[] noPrimeB (long n){

        boolean [] prime = new boolean[(int)Math.sqrt(n)+1]; // 0~N 까지 숫자가 noPrime 경우 true, 아닐경우(소수일 경우) false
        prime[0]=prime[1]=true;         // 0, 1 은 소수가 아님

        for(int i=2; i<(int)Math.sqrt(n)+1; i++){ // N*N 형태의 정사각 배열에서
            if(!prime[i]){
                for(int j=i*i; j<(int)Math.sqrt(n)+1; j+=i) // i*i 이후의 i의 배수 -
                    prime[j]=true;
            }
        }
        return prime;
    }



    static int setPrimeFacArr (long N){

        int answer=1;

        boolean [] np = noPrimeB(N); // 최대값까지의 소수 판별 배열 생성
        for(int i=0;i<(int)Math.sqrt(N)+1;i++){
            if(!np[i]){
                answer= N%i==0 ? i : answer;
            }
        }
       // System.out.println("primelist : "+primelist);


/*
        for(long i : intFac)
            System.out.printf(i + " ");
        System.out.println();
*/
        return answer;
    }


    static boolean[] noPrime (int N){

        boolean [] prime = new boolean[N+1]; // 0~N 까지 숫자가 noPrime 경우 true, 아닐경우(소수일 경우) false
        prime[0]=prime[1]=true;         // 0, 1 은 소수가 아님

        for(int i=2; i*i<=N; i++){ // N*N 형태의 정사각 배열에서
            if(!prime[i]){
                for(int j=i*i; j<=N; j+=i) // i*i 이후의 i의 배수 -
                    prime[j]=true;
            }
        }
        return prime;
    }
}
