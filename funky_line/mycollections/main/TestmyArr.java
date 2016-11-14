package com.funky_line.mycollections.main;

import com.funky_line.mycollections.realisation.LinkList;

/**
 * Created by Rudniev Oleksandr on 10.11.2016.
 */
public class TestmyArr {
    public static void main(String[] args) {
        LinkList<String> test = new LinkList<>();
        System.out.println("Проверка метода isEmpty, т.к. коллекция пустая вернет " + test.isEmpty());
        test.add(0);
        test.add("Буратинка1");

        for (int i = 0; i < 5; i++) {
            test.add("Буратинка" + (i + 2));
        }

        if (test.contains("Буратинка")) {
            System.out.println("Размер нашей коллекции = " + test.size());
        }

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }

        System.out.println("Дополнительная проверка метода isEmpty," +
                " т.к. коллекция имеет элементы вернет " + test.isEmpty());

        System.out.println("Проведем удаление элемента по индексу 4 " + test.remove(4));
        System.out.println("После операции удаления размер нашей коллекции = " + test.size());

        System.out.println("Вывод в терминал оставшихся элементов коллекции");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        System.out.println("Испытаем метод set() который заменит 1 элемент коллекции");
        System.out.println("На данный момент 1 элемент коллекции содержит " + test.get(1));
        System.out.println("Запишем в 1 элемент строку Артемон " + test.set(1, "Артемон"));
        System.out.println("Теперь 1 элемент коллекции содержит " + test.get(1));

        System.out.println("Произведем очистку коллекции");
       // test.clear();
        System.out.println("После очистки коллекции ее размер равен = " + test.size());
        System.out.println(test);

        for (int i = 0; i <test.size() ; i++) {
            System.out.println(test.get(i));

        }
    }
}