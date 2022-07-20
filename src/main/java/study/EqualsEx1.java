package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        System.out.println(v1==v2);
        System.out.println(v1.equals(v2));
        System.out.println(v1.value==v2.value);
        v2 = v1;
        System.out.println(v1==v2);
        System.out.println(v1.equals(v2));

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj1==obj2);


        String a = "yejin";
        String b = "yejin";

        String c = new String("yejin");
        String d = new String("yejin");


        System.out.println("a : "+a+" b : "+b);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println("c : "+c+" d : "+d);
        System.out.println(c==d);
        System.out.println(c.equals(d));
        c=c+a;
        d=d+a;
        System.out.println("c : "+c+" d : "+d);
        System.out.println(c==d);
        System.out.println(c.equals(d));
        c=c.concat(a);
        d=d.concat(a);
        System.out.println("c : "+c+" d : "+d);
        System.out.println(c==d);
        System.out.println(c.equals(d));


        Map<Person,String> m = new HashMap<>();
        m.put(new Person(1L),"yejin");
        System.out.println(m.get(new Person(1L)));


    } // main
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }
}
class Person {
    long id;

    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof Person) {
            return id ==((Person)obj).id;
        } else {
            return false;
        }
    }


    Person(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}