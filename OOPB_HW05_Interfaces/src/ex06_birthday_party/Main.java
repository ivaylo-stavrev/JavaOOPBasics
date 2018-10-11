package ex06_birthday_party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Indexable> incomers = new LinkedList<>();
        List<Bornable> allBorned = new LinkedList<>();

        String line = reader.readLine();
        while (true) {
            if ("End".equals(line)) {
                break;
            }
            String[] lineSplitted = line.split("\\s+");

            String organismType = lineSplitted[0];
            String arg1 = lineSplitted[1];
            String arg2 = lineSplitted[2];
            String arg3 = "";
            String arg4 = "";
            if(lineSplitted.length > 3) {
                arg3 = lineSplitted[3];
                arg4 = lineSplitted[4];
                incomers.add(new Citizen(arg1, arg2, arg3, arg4));
            } else {
                incomers.add(new Robot(arg1, arg2));
            }

            switch (organismType) {
                case "Citizen":
                    allBorned.add(new Citizen(arg1, arg2, arg3, arg4));
                    break;
                case "Pet":
                    allBorned.add(new Pet(arg1, arg2));
                    break;
            }

            line = reader.readLine();
        }
        String endingCheck = reader.readLine();
        allBorned.stream()
                .filter(born -> born.getBirthDate().endsWith(endingCheck))
                .forEach(born -> System.out.println(born.getBirthDate()));


        //incomers.stream().forEach(index -> {
        //    if(index.getId().endsWith(endingCheck)) {
        //        System.out.println(index.getId());
        //    }
        //}) ;
    }
}
