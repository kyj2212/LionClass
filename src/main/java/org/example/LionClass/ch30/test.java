package org.example.LionClass.ch30;

import java.util.ArrayList;

public class test {


    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        ArrayList<Integer> a = new ArrayList<>();
        Object obj=null;
        Integer i = 100;
        obj=200;
        i=(Integer)obj;
        System.out.println(i);

        a.size();
        a.add(1);
        a.add(2);

        System.out.println("remove(1) : "+a.remove(1));
        //a.remove(1);
        System.out.println("remove(new Integer(1)) : "+a.remove(new Integer(1)));
        System.out.println("isEmpty() : "+a.isEmpty());
        //a.addAll()
    }


}
