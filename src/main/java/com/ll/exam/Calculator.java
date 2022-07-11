package com.ll.exam;

import java.util.StringTokenizer;

public class Calculator {

    static String result;

    public static void main(String[] args) {


        String str1 = "1-2+3+1";
       // StringTokenizer st = new StringTokenizer(str1);


        System.out.println(Integer.parseInt(cal(str1)));

/*
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

*/
    }


    static boolean isOperator(char c){
        if("+-*/".indexOf(c)!=-1)
            return true;
        else return false;
    }

    static String cal(String str){
        if(str.length()<=1)
            return str;
        str=multiply(str);
        str=plusOrminus(str);

        return str;
    }





  /*  static void mode(int op, int a, int b){
        if(op=='+'){
            plus(a,b);
        }else if(op=='-'){
            substract(a,b);
        }else if(op=='*'){
            multiply(a,b);
        }else if(op=='/'){
            divide(a,b);
        }
    }


   */

    static String plusOrminus(String str){

        //int i=Math.min(str.indexOf('+'),str.indexOf('-'));
        int i = str.indexOf('+');
        int j = str.indexOf('-');
        if( i!=-1 || j!=-1) {
            if(i==-1)
                return substract(str,j);
            else if(j==-1)
                return plus(str,i);
            else
                return i<j?plus(str,i):substract(str,j);
        }
        return str ;
    }



    static String multiply(String str){
        int a,b;


        int i=str.indexOf('*');
        if(str.length()>1 && i!=-1) {
            a = Integer.parseInt(cal(str.substring(0, i)));
            System.out.println(a);
            b = Integer.parseInt(cal(str.substring(i + 1)));
            System.out.println(b);
            return result = String.valueOf(a*b);
        }
        return str;
    }

    static String plus(String str, int i){
        int a,b;

      //  if(str.length()>1){
            a = Integer.parseInt(cal(str.substring(0, i)));
            System.out.println(a);
            b = Integer.parseInt(cal(str.substring(i + 1)));
            System.out.println(b);
            return String.valueOf(a+b);
       // }
      //  return str;
    }

    static String substract(String str, int i){
        int a,b;

        a = Integer.parseInt(cal(str.substring(0, i)));
        System.out.println(a);
        b = Integer.parseInt(cal(str.substring(i + 1)));
        System.out.println(b);
        return String.valueOf(a-b);
    }






    /*
    static int divide(int a, int b){
        result = a/b;
        System.out.println("result : "+result);
        return result;
    }



     */

}

