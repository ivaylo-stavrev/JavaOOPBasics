package ex03_opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new TreeMap<>();
        String personName;
        int personAge;

        int numOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfInputs; i++) {
            String[] personArgs = reader.readLine().split(" ");
            personName = personArgs[0];
            personAge = Integer.parseInt(personArgs[1]);
            persons.put(personName, new Person(personName, personAge));
        }

        for (String p : persons.keySet()) {
            if (persons.get(p).getAge() > 30) {
                System.out.printf("%s - %d%n", persons.get(p).getName(), persons.get(p).getAge());
            }
        }
    }
}
