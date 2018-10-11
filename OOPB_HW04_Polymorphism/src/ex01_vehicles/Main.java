package ex01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInput = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        String[] truckInput = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int numOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] lineSplitted = reader.readLine().split("\\s+");

            String cmd = lineSplitted[0];
            String vehicleType = lineSplitted[1];
            double distanceOrLiters = Double.parseDouble(lineSplitted[2]);

            switch (cmd) {
                case "Drive":
                    if("Car".equals(vehicleType)) {
                        car.drive(distanceOrLiters);
                    } else {
                        truck.drive(distanceOrLiters);
                    }
                    break;
                case "Refuel":
                    if("Car".equals(vehicleType)) {
                        car.refuel(distanceOrLiters);
                    } else {
                        truck.refuel(distanceOrLiters);
                    }
                    break;
            }
        }
        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
    }
}
