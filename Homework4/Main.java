package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Homework 4
 * @version 1
 * @author Parunov Ilya
 */

public class Main {

    public static void main(String[] args) throws Exception, UnsupportedEncodingException {

        try {
            args[0].trim();
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("No argument received!");
        }

        String words = "";
        int count = 0;

        try (Scanner s = new Scanner(new FileReader(args[0]))) {
            Pattern pattern = Pattern.compile("[А-Яа-яA-Za-z]+");

            while (s.hasNextLine()) {
                Matcher matcher = pattern.matcher(s.nextLine());
                while (matcher.find()) {
                    count++;
                }
            }

        }catch (IOException e){
            System.out.println(e);
        }

        System.out.println(count);;

    }
}
