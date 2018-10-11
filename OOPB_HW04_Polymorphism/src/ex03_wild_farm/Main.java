package ex03_wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Mammal> animals = new LinkedList<>();
        Mammal animal = null;

        String line = reader.readLine();
        while (true) {
            if ("End".equals(line)) {
                break;
            }
            String[] lineSplitted = line.split("\\s+");

            String animalType = lineSplitted[0];
            String animalName = lineSplitted[1];
            double animalWeight = Double.parseDouble(lineSplitted[2]);
            String liningRegion = lineSplitted[3];
            try {
                if (lineSplitted.length == 5) {
                    String breed = lineSplitted[4];
                    animal = new Cat(animalName, animalType, animalWeight, liningRegion, breed);
                } else {
                    switch (animalType) {
                        case "Mouse":
                            animal = new Mouse(animalName, animalType, animalWeight, liningRegion);
                            break;
                        case "Tiger":
                            animal = new Tiger(animalName, animalType, animalWeight, liningRegion);
                            break;
                        case "Zebra":
                            animal = new Zebra(animalName, animalType, animalWeight, liningRegion);
                            break;
                    }
                    //animals.add(animal);
                }
            }
            catch (IllegalArgumentException iae) {
                iae.getMessage();
            }

            lineSplitted = reader.readLine().split("\\s+");
            String foodType = lineSplitted[0];
            int foodQuantity = Integer.parseInt(lineSplitted[1]);
            Food food = null;
            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
            }
            animal.makeSound();
            animal.eat(food);

            animals.add(animal);

            line = reader.readLine();
        }

        for (Mammal anim : animals) {
            System.out.println(anim.toString());
        }
    }
}
