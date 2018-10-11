package ex05_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Indexable> incomers = new LinkedList<>();

        String line = reader.readLine();
        while (true) {
            if ("End".equals(line)) {
                break;
            }
            String[] lineSplitted = line.split("\\s+");

            String arg0 = lineSplitted[0];
            String arg1 = lineSplitted[1];
            if(lineSplitted.length > 2) {
                String arg2 = lineSplitted[2];
                incomers.add(new Citizen(arg0, arg1, arg2));
            } else {
                incomers.add(new Robot(arg0, arg1));
            }

            line = reader.readLine();
        }
        String endingCheck = reader.readLine();
        incomers.stream().forEach(index -> {
            if(index.getId().endsWith(endingCheck)) {
                System.out.println(index.getId());
            }
        }) ;
    }
}
