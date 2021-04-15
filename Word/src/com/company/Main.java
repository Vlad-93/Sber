package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String text = "Шахматы — настольная логическая игра со специальными фигурами на 64-клеточной доске для двух соперников, \n" +
                "сочетающая в себе элементы искусства (в том числе в части шахматной композиции), науки и спорта. \n" +
                "В шахматы обычно играют два игрока друг против друга. Также возможна игра одной группы шахматистов против \n" +
                "другой или против одного игрока, такие партии зачастую именуются консультационными. Кроме того, \n" +
                "существует практика сеансов одновременной игры, когда против одного сильного игрока играет несколько \n" +
                "противников, каждый на отдельной доске. Правила игры в основном сложились к XV веку; в современных \n" +
                "официальных турнирах применяются правила Международной шахматной федерации, которыми регламентируются \n" +
                "не только передвижение фигур, но и права судьи, правила поведения игроков и контроль времени. \n" +
                "Игра, осуществляемая дистанционно, например, по переписке, по телефону или через Интернет, имеет особые правила. \n" +
                "Существует множество вариантов шахмат, отличающихся от классических: с нестандартными правилами, фигурами, \n" +
                "размерами доски и т. п. Соответствующий раздел шахматной композиции — сказочные шахматы. Некоторые аспекты \n" +
                "шахматной игры изучаются в математике (например, классические «Задача о ходе коня» и «Задача о восьми ферзях»), \n" +
                "в том числе при помощи компьютерного моделирования.";

        String[] strings = text.split("\n");
        String[] words = text.toLowerCase().split("[^a-zA-zа-яА-я]+");

        // задача 1: кол-во разных слов
        System.out.println("---------------------------------------------");
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println("Количество слов в тексте = " + set.size());

        // задача 2: вывод слов, отсортированных по длине
        System.out.println("---------------------------------------------");
        Comparator<String> comparator = new CheckerLength();
        TreeSet<String> sortedSet = new TreeSet<>(comparator);
        sortedSet.addAll(Arrays.asList(words));
        System.out.println(sortedSet);

        // задача 3: кол-во повторений каждого слова
        System.out.println("---------------------------------------------");
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words)
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);

        System.out.println(map);

        // задача 4: строки в обратном порядке
        System.out.println("---------------------------------------------");
//        for (int i = strings.length - 1; i >= 0; i--)
//            System.out.println(strings[i]);

        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(strings));

        while (!stack.isEmpty())
            System.out.println(stack.pop());

        // задача 5: свой итератор для обратного порядка
        System.out.println("---------------------------------------------");
        MyIterator<String> iterator = new MyIterator<>(Arrays.asList(strings));

        while (iterator.hasNext())
            System.out.println(iterator.next());

        // задача 6: вывод строки по номеру
        System.out.println("---------------------------------------------");
        Scanner scan = new Scanner(System.in);

        while (true)
            System.out.println(strings[scan.nextInt()]);
    }
}
