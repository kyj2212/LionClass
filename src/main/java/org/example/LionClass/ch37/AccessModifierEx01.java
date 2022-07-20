package org.example.LionClass.ch37;


// 문제 : 사람의 id를 출력해주세요.
// 조건 : 사람의 id를 20으로 설정해주세요.
// 조건 : 사람 클래스의 id 필드의 private 속성은 수정할 수 없습니다.

class AccessModifierEx01 {
    Human h1 = new Human();
    public void run() {
        h1.setId(20);
        System.out.println("제 번호는 "+h1.getId()+" 입니다.");
    }
    // 출력 : 제 번호는 20 입니다.

}
class Human {
    private int id;
    public void setId(int id){this.id=id;}
    public int getId(){return this.id;}
    // 힌트 : 여기에 메소드 2개 추가해야 합니다.
}

class Main {
    public static void main(String[] args) {
        new AccessModifierEx01().run();
    }
}

