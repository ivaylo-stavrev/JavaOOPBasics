package ex06_raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> availableCars = new LinkedList<>();

        int numOfLines = Integer.parseInt(reader.readLine());
        String currentModel;
        int currentSpeed;
        int currentPower;
        int currentWeight;
        String currentType;
        double currentPressure1;
        int currentAge1;
        double currentPressure2;
        int currentAge2;
        double currentPressure3;
        int currentAge3;
        double currentPressure4;
        int currentAge4;
        for (int i = 0; i < numOfLines; i++) {
            String[] inputArgs = reader.readLine().split("\\s+");
            currentModel = inputArgs[0];
            currentSpeed = Integer.parseInt(inputArgs[1]);
            currentPower = Integer.parseInt(inputArgs[2]);
            currentWeight = Integer.parseInt(inputArgs[3]);
            currentType = inputArgs[4];
            currentPressure1 = Double.parseDouble(inputArgs[5]);
            currentAge1 = Integer.parseInt(inputArgs[6]);
            currentPressure2 = Double.parseDouble(inputArgs[7]);
            currentAge2 = Integer.parseInt(inputArgs[8]);
            currentPressure3 = Double.parseDouble(inputArgs[9]);
            currentAge3 = Integer.parseInt(inputArgs[10]);
            currentPressure4 = Double.parseDouble(inputArgs[11]);
            currentAge4 = Integer.parseInt(inputArgs[12]);

            availableCars.add(new Car(currentModel, currentSpeed, currentPower, currentWeight, currentType, currentPressure1, currentAge1, currentPressure2, currentAge2, currentPressure3, currentAge3, currentPressure4, currentAge4));
        }

        String cargoType = reader.readLine();
        switch (cargoType) {
            case "fragile":
                for (Car car : availableCars) {
                    if (cargoType.equals(car.getCargo().getType()) && car.isTirePressureUnderOne()) {
                        car.printModel();
                    }
                }
                break;
            case "flamable":
                for (Car car : availableCars) {
                    if (cargoType.equals(car.getCargo().getType()) && (car.getEngine().getPower() > 250)) {
                        car.printModel();
                    }
                }
                break;
        }
    }
}
