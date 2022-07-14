package org.example.LionClass.cch34;

// 문제 : 몇명의 사람의 정보를 받을지 입력받고 입력받은 수 만큼 이름과 나이를 입력받은 후 저장해주세요.
// 조건 : malloc을 사용할 수 없습니다.
// 출력예시
/*
사람의 숫자를 입력해주세요. : 3[엔터]
1번째 사람의 이름을 입력해주세요 : aa[엔터]
1번째 사람의 나이를 입력해주세요 : 33[엔터]
2번째 사람의 이름을 입력해주세요 : bb[엔터]
2번째 사람의 나이를 입력해주세요 : 50[엔터]
3번째 사람의 이름을 입력해주세요 : cc[엔터]
3번째 사람의 나이를 입력해주세요 : 42[엔터]
1번째 사람의 이름, 나이 : aa, 33세
2번째 사람의 이름, 나이 : bb, 50세
3번째 사람의 이름, 나이 : cc, 42세
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GatherPeople {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("사람의 숫자를 입력해 주세요. : ");
        int max_people=Integer.parseInt(br.readLine().trim());

        // use arraylist
        System.out.println("== use ArrayList ==");
        ArrayList<Person> plist = new ArrayList<>();

        for(int num=1;num<max_people+1;num++){
            System.out.printf(num+"번째 사람의 이름을 입력해 주세요 : ");
            Person p = new Person();
            String str = br.readLine().trim();
            p.setStrName(str);
            p.setCharName(str.toCharArray());
            System.out.printf(num+"번째 사람의 나이를 입력해 주세요 : ");
            p.setAge(Integer.parseInt(br.readLine().trim()));
            plist.add(p);
        }

        for(int num=0;num<max_people;num++){
            System.out.println(num+1+"번째 사람의 이름(char)/(string), 나이 : "
                    +String.valueOf(plist.get(num).charName)+"/"
                    +plist.get(num).strName
                    +", "+plist.get(num).age);
        }

    }


    private static class Person {
        String strName;
        char [] charName;
        int age;

        public void setStrName(String strName) {
            this.strName = strName;
        }

        public void setCharName(char[] charName) {
            this.charName = charName;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

