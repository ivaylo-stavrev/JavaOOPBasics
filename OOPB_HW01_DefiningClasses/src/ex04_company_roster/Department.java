package ex04_company_roster;

import java.util.*;

public class Department {
    private static int numOfEmployees;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void addEmployeeInDep (Employee emp) {
        employees.add(emp);
        numOfEmployees++;
    }

    public double getAvgSalary () {
        double sum = 0;

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        //System.out.printf("%s: %f / %d%n", this.name, sum, employees.size());
        return sum / employees.size();
        //return Double.parseDouble(System.out.printf("%.2f", sum/employees.size()));
    }

    public void sortedPrint() {
        //for (Employee employee : employees) {
        Set<Employee> tempSet = new LinkedHashSet<>();
        tempSet.addAll(employees);
        tempSet.stream()
                .sorted((a, b) ->  Double.compare(b.getSalary(), a.getSalary()))
                .forEach(e -> e.print());
                //.print();

            //System.out.println(employee);
        //}
    }
}
