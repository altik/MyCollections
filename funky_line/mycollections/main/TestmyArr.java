package com.funky_line.mycollections.main;

import com.funky_line.mycollections.realisation.LinkList;

/**
 * Created by Rudniev Oleksandr on 10.11.2016.
 */
public class TestmyArr {
    public static void main(String[] args) {
        LinkList<String> test = new LinkList<>();
        test.add("Ноль");
        test.add(1, "Один");
        System.out.println(test.size());
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        System.out.println(test.size());
        for (int i = 0; i < 33; i++) {
            test.add("ddd");
        }
        System.out.println(test.size());
        test.remove(20);
        System.out.println(test.size());

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));

        }
        System.out.println(test);
        System.out.println(test.get(22));
        System.out.println(test.contains("Ноль"));
        test.clear();
        //      System.out.println(test.get(3));
        System.out.println(test.isEmpty());
    }
}