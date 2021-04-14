package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * FinalHomework
 *
 * @author Parunov Ilya
 * @version 1
 */

public class Main {

    public static List<List<String>> readFile(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(fileName));
        List<String> file = new ArrayList<>();
        List<List<String>> file2 = new ArrayList<>();
        while (s.hasNextLine()) {
            file.add(s.nextLine());
        }

        for (String x : file) {
            file2.add(Arrays.asList(x.split(" ")));
        }
        return file2;
    }

    public static void task1() throws IOException {

        List<List<String>> sellers = readFile("Sellers.txt");
        List<List<String>> sales = readFile("Sales.txt");

        Map<Integer, List<String>> slrs = new TreeMap<>();
        Map<Integer, Integer> amountOfSales = new TreeMap<>();
        Map<Integer, Integer> sortedSales;

        for (List<String> x : sellers){
            slrs.put(Integer.valueOf(x.get(0)), x.subList(1,3));
        }

        for (List<String> x : sales) {

            Integer key = Integer.valueOf(x.get(1));
            Integer value = Integer.valueOf(x.get(3));


            try {
                amountOfSales.put(key, amountOfSales.get(key) + value);

            } catch (NullPointerException e) {
                amountOfSales.put(key, value);
            }
        }

        sortedSales = amountOfSales.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));


        FileWriter fileWrite = new FileWriter("task1Output.txt");
        int counter = 0;
        for (Integer x : sortedSales.keySet()){
            if (counter >= 5){
                break;
            }
            String s = slrs.get(x).get(0) + " " + slrs.get(x).get(1) + "\n";
            fileWrite.write(s);
            counter++;
        }
        fileWrite.close();

        System.out.println(sortedSales);
    }

    public static void task2() {

    }

    public static void main(String[] args) throws IOException {

        task1();

    }
}
