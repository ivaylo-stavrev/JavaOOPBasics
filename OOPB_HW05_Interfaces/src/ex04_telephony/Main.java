package ex04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Smartphone phone = new Smartphone();

        String[] numbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        for (String number : numbers) {
            phone.call(number);
        }

        for (String url : urls) {
            phone.browse(url);
        }

    }
}
