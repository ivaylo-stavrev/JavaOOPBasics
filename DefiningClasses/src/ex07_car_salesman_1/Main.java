package ex07_car_salesman_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Engine> availableEngines = new HashMap<>();
        Map<String, Car> availableCars = new LinkedHashMap<>();

        int enginesCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < enginesCount; i++) {
            String[] enginesArgs = reader.readLine().split("\\s+");
            String currentEngineModel = enginesArgs[0];
            int currentEnginePower = Integer.parseInt(enginesArgs[1]);
            int currentEngineDisplacement = -1;
            String currentEngineEfficiency = "n/a";

            if (enginesArgs.length > 2) {
                if (enginesArgs.length == 4) {
                    currentEngineDisplacement = Integer.parseInt(enginesArgs[2]);
                    currentEngineEfficiency = enginesArgs[3];
                } else {
                    if (enginesArgs[2].matches("\\d+")) {
                        currentEngineEfficiency = "n/a";
                        currentEngineDisplacement = Integer.parseInt(enginesArgs[2]);
                    } else {
                        currentEngineEfficiency = enginesArgs[2];
                        currentEngineDisplacement = -1;
                    }
                }
            }
            availableEngines.put(currentEngineModel, new Engine(currentEngineModel, currentEnginePower, currentEngineDisplacement, currentEngineEfficiency));
        }

        int carsCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carsArgs = reader.readLine().split("\\s+");
            String currentCarModel = carsArgs[0];
            String currentCarEngine = carsArgs[1];
            int currentEngineWeight = -1;
            String currentEngineColor = "n/a";

            if (carsArgs.length > 2) {
                if (carsArgs.length == 4) {
                    currentEngineWeight = Integer.parseInt(carsArgs[2]);
                    currentEngineColor = carsArgs[3];
                } else {
                    if (carsArgs[2].matches("\\d+")) {
                        currentEngineColor = "n/a";
                        currentEngineWeight = Integer.parseInt(carsArgs[2]);
                    } else {
                        currentEngineColor = carsArgs[2];
                        currentEngineWeight = -1;
                    }
                }
            }
            availableCars.put(currentCarModel, new Car(currentCarModel, availableEngines.get(currentCarEngine), currentEngineWeight, currentEngineColor));
        }

        for (Car car : availableCars.values()) {
            //System.out.println(car.toString());
            car.print();
        }

    }
}
