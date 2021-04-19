package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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

    public static void task1() throws JAXBException {

        Unmarshaller unmarshaller = JAXBContext.newInstance(Sellers.class, Seller.class, Sale.class, Sales.class).createUnmarshaller();
        Sellers sellers = (Sellers) unmarshaller.unmarshal(new File("Sellers.xml"));
        Sales sales = (Sales) unmarshaller.unmarshal(new File("Sales.xml"));

        Map<Integer, String> slrs = new TreeMap<>();
        Map<Integer, Integer> amountOfSales = new TreeMap<>();
        Map<Integer, Integer> sortedSales;

        for (Seller x : sellers.getSellers()) {
            String fullName = x.getLastname() + " " + x.getFirstname();
            slrs.put(x.getId(), fullName);
        }

        for (Sale x : sales.getSales()) {

            Integer key = x.getSellerid();
            Integer value = x.getAmount();


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


        List<TopSeller> topSellers = new ArrayList<>();
        int counter = 0;
        int place = 1;
        for (Integer x : sortedSales.keySet()) {
            if (counter >= 5) {
                break;
            }

            TopSeller z = new TopSeller();
            z.place = place;
            z.name = slrs.get(x);
            topSellers.add(z);
            counter++;
            place++;
        }

        TopSellers ans = new TopSellers();
        ans.setTopSellers(topSellers);


        Marshaller marshaller = JAXBContext.newInstance(TopSeller.class, TopSellers.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ans, new File("OutputTask1.xml"));
    }

    public static void task2() throws JAXBException {

        Unmarshaller unmarshaller = JAXBContext.newInstance(Sale.class, Sales.class).createUnmarshaller();
        Sales sales = (Sales) unmarshaller.unmarshal(new File("Sales.xml"));

        Map<String, Integer> amountOnDates = new TreeMap<>();
        for (Sale x : sales.getSales()) {

            String key = x.getDate();
            Integer value = x.getAmount();
            try {
                amountOnDates.put(key, amountOnDates.get(key) + value);

            } catch (NullPointerException e) {
                amountOnDates.put(key, value);
            }
        }

        Map<String, Integer> sortedDates;
        sortedDates = amountOnDates.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));


        System.out.println(sortedDates);

        List<TopDay> topDays = new ArrayList<>();
        int counter = 0;
        int place = 1;
        for (Map.Entry<String, Integer> x : sortedDates.entrySet()) {
            if (counter >= 5) {
                break;
            }

            TopDay z = new TopDay();
            z.place = place;
            z.date = x.getKey();
            z.amount = x.getValue();
            topDays.add(z);
            counter++;
            place++;
        }

        TopDays ans = new TopDays();
        ans.setTopDays(topDays);


        Marshaller marshaller = JAXBContext.newInstance(TopDay.class, TopDays.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ans, new File("OutputTask2.xml"));
    }

    public static void main(String[] args) throws JAXBException {
        task1();
        task2();
    }
}
