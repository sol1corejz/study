package com.company;

import java.util.*;

/**
 * Java collections (Homework 6)
 * @version 1
 * @author Parunov Ilya
 */

public class Main {

    public static String normalizeDir(String dir){

        String[] splitStr = dir.split("/");//Разделяем строку и записываем её в массив
        Stack<String> res = new Stack<>();//Лист для строки без точек
        Stack<String> resF = new Stack<>();//Дополнительный лист для обработанной строки
        StringBuilder disban = new StringBuilder();//Строка для сохранения неизвестных корневых путей

        //Записываем строку как есть в первый лист
        res.addAll(Arrays.asList(splitStr));

        //Создаем итератор  и удаляем все точки из нашего листа
        ListIterator<String> it = res.listIterator();
        while (it.hasNext()) {
            if (it.next().equals(".")) it.remove();
        }

        //Нормализуем
        it = res.listIterator();
        while (it.hasNext()) {
            try {
                String cur = it.next();
                if (cur.equals("..")) {
                    it.remove();
                    resF.remove(resF.size() - 1);
                } else resF.add(cur);

            } catch (IndexOutOfBoundsException e) {
                disban.append("../");
            }
        }
        //Записываем результат в строку
        StringBuilder result = new StringBuilder();
        for (String s : resF) {
            result.append(s).append("/");
        }

        return disban + result.toString().substring(0,result.length()-1);
    }

    public static void main(String[] args) {

        String dir1 = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";
        String dir2 = "task_6_2/src/./../../task_6_1/../../../мемы/./котики";
        String ans1 = normalizeDir(dir1);
        String ans2 = normalizeDir(dir2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}