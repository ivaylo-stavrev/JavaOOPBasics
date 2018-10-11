package ex07_food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Indexable> incomers = new LinkedList<>();
        List<Bornable> allBorned = new LinkedList<>();
        Map<String, Buyer> buyers = new HashMap<>();
        String line;

        int numberOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            line = reader.readLine();
            String[] lineSplitted = line.split("\\s+");

            String name = lineSplitted[0];
            String age = lineSplitted[1];
            String arg2 = lineSplitted[2];
            if(lineSplitted.length > 3) {
                String arg3 = lineSplitted[3];
                buyers.put(name, new Citizen(name, age, arg2, arg3));
            } else {
                buyers.put(name, new Rebel(name, age, arg2));
            }
        }

        line = reader.readLine();
        while (true) {
            if ("End".equals(line)) {
                break;
            }
            if(buyers.containsKey(line)) {
                buyers.get(line).buyFood();
            }

            line = reader.readLine();
        }
        int sum = 0;
        sum = buyers.values()
                .stream()
                .mapToInt(buyer -> buyer.getFood())
                .sum();
        System.out.printf("%d%n", sum);
    }
}
