package org.example.LionClass.ch24;


class RunCar {
    public static void main(String[] args) {
        CarnoStatic c = new CarnoStatic();
        c.run();

        // use static
        Car.run();

    }

    static class Car {
        static void run() {
            System.out.println("(static) 자동차가 달립니다.");
        }
    }

}

class CarnoStatic{
    void run(){
        System.out.println("(no static) 자동차가 달립니다.");
    }
}


