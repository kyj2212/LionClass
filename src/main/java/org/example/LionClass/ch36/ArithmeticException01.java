package org.example.LionClass.ch36;

public class ArithmeticException01 {

    static class Main{

        public static void main(String[] args) {
            try{
                int rs = Calculater.divide(10, 0);
                System.out.println(rs);
            }catch (ArithmeticException e){
                System.out.println("Can't divide by 0");
            }catch (Exception e){
                System.out.println("Cant divide");
            }
        }
    }
    private class Calculater {
        static int divide(int a, int b) throws ArithmeticException {
            return a/b;
        }
    }
}


