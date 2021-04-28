package com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
            System.out.println("Введите url:");
	        String url = scanner.next();

            try {
                readContent(url);
            } catch (IOException e) {
                System.out.println(e.toString());
                continue;
            }

            break;
        }

    }

    static void readContent(String url) throws IOException {
        URLConnection urlConnection = new URL(url).openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);
    }

}
