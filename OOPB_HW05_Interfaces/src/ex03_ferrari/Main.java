package ex03_ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String driverName = reader.readLine();

        Ferrari car = new Ferrari(driverName);

        System.out.printf("%s/", car.getModel());
        car.breaks();
        System.out.printf("/");
        car.pushTheGasPedal();
        System.out.printf("/%s%n", car.getDriver());


        // Inline checker
        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Pushable.class.getSimpleName();
        boolean isCreated = Pushable.class.isInterface();
        try {
            if (!isCreated) {
                throw new IllegalClassFormatException("No interface created!");
            }
        } catch (IllegalClassFormatException icfe) {
            System.out.println(icfe.getMessage());
        }
    }
}
