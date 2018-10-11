package ex02_vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Vehicle> vehicles = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.##");

        String[] carInput = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        vehicles.put(carInput[0], car);
        String[] truckInput = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));
        vehicles.put(truckInput[0], truck);
        String[] busInput = reader.readLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));
        vehicles.put(busInput[0], bus);

        int numOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfLines; i++) {
            String[] lineSplitted = reader.readLine().split("\\s+");

            String cmd = lineSplitted[0];
            String vehicleType = lineSplitted[1];
            double distanceOrLiters = Double.parseDouble(lineSplitted[2]);

            switch (cmd) {
                case "Drive":
                    if(vehicles.get(vehicleType).drive(distanceOrLiters)) {
                        System.out.printf("%s travelled %s km%n", vehicleType, df.format(distanceOrLiters));
                    } else {
                        System.out.printf("%s needs refueling%n", vehicleType);
                    }
                    break;
                case "Refuel":
                    int refuelResult = vehicles.get(vehicleType).refuel(distanceOrLiters);
                    if(refuelResult == -1) {
                        System.out.println("Fuel must be a positive number");
                    } else if(refuelResult == 0) {
                        System.out.println("Cannot fit fuel in tank");
                    }
                    break;
                case "DriveEmpty":
                    if(vehicles.get(vehicleType).driveEmpty(distanceOrLiters)) {
                        System.out.printf("%s travelled %s km%n", vehicleType, df.format(distanceOrLiters));
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                    break;
            }
        }
        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}
