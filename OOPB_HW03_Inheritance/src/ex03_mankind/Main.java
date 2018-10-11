package ex03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = reader.readLine().split("\\s+");
            Student student = new Student(line[0], line[1], line[2]);
            System.out.println(student.toString());

            line = reader.readLine().split("\\s+");
            Worker worker = new Worker(line[0], line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]));
            System.out.println(worker.toString());
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
