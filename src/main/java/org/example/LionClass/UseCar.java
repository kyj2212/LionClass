package org.example.LionClass;

public class UseCar {
    public static void main(String[] args) {
        System.out.println("1. 3개의 자동차가 각각 1번씩 달리기");
        Car c1 = new Car("CarA", 100);
        Car c2 = new Car("CarB", 30);
        Car c3 = new Car("CarC", 200);

        c1.run();
        c2.run();
        c3.run();


        System.out.println('\n'+"2. 2명의 플레이어가 각각 자동차를 타고 달리기");
        Player p1 = new Player("김예진",new Car("소나타",100));
        Player p2 = new Player("홍길동", new Car("제네시스",120));

        p1.ride();
        p2.ride();

        System.out.println('\n'+"3. 서로 다른 최고속력으로 달리기");
        c1.run(500);
        c2.run(20);

    }


}

class Player {
    String name;
    Car car;
    Player(String name, Car car){
        this.name =name;
        this.car=car;
    }
    void ride(){
        System.out.println(name+"은 "+car.name+"을 탑승합니다.");
        this.car.run();
    }
}

class Car {
    int velocity;
    String name;

    Car(){
        this("레이",0);
    }

    Car(String name, int velocity){
        this.name = name;
        this.velocity=velocity;
    }
    void run(){
        System.out.println(name+"가 "+velocity+" km/h 로 달립니다.");
    }
    void run(int velocity){
        this.velocity=velocity;
        System.out.println(name+"가 "+this.velocity+" km/h 로 달립니다.");
    }
}
