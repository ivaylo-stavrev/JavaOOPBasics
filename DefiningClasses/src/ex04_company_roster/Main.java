package ex04_company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Set<Department> departments = new HashSet<>();
        Map<String, Department> departments = new HashMap<>();
        //List<Department> departments = new ArrayList<>();
        String currentName;
        double currentSalary;
        String currentPosition;
        String currentDepartment;
        String currentEmail;
        int currentAge;

        int numOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfInputs; i++) {
            String[] lineArgs = reader.readLine().split(" ");
            currentName = lineArgs[0];
            currentSalary = Double.parseDouble(lineArgs[1]);
            currentPosition = lineArgs[2];
            currentDepartment = lineArgs[3];
            currentEmail = "n/a";
            currentAge = -1;
            if (lineArgs.length > 4) {
                if (lineArgs.length == 6) {
                    currentEmail = lineArgs[4];
                    currentAge = Integer.parseInt(lineArgs[5]);
                } else {
                    if (lineArgs[4].contains("@")){
                        currentEmail = lineArgs[4];
                        currentAge = -1;
                    }
                    else {
                        currentEmail = "n/a";
                        currentAge = Integer.parseInt(lineArgs[4]);
                    }
                }
            }

            Employee currentEmployee = new Employee(currentName, currentSalary, currentPosition, currentDepartment, currentEmail, currentAge);

            if (!departments.containsKey(currentDepartment)) {
                departments.put(currentDepartment, new Department(currentDepartment));
            }
            departments.get(currentDepartment).addEmployeeInDep(currentEmployee);

            //for (Department department : departments) {
            //    if (currentDepartment.equals(department.getName())) {
            //        department.addEmployeeInDep(currentEmployee);
            //    }
            //}
        }

        String maxAvgSalaryDeptName = calcMaxAvgSalaryDepartment(departments);
        System.out.printf("Highest Average Salary: %s%n", maxAvgSalaryDeptName);

        departments.get(maxAvgSalaryDeptName).sortedPrint();

        //for (Department department : departments.values()) {
        //    if (department.getName().equals(maxAvgSalaryDeptName)) {

                //department.print();
        //    }
        //}
    }

    private static String calcMaxAvgSalaryDepartment(Map<String, Department> departments) {
        String maxAvgSalaryDeptName = "";
        double maxDeptAvgSalary = 0;
        double avgSalary = 0;
        for (Department department : departments.values()) {
            avgSalary = department.getAvgSalary();
            //System.out.printf("IVO: %f", department.getAvgSalary());
            if (avgSalary > maxDeptAvgSalary) {
                maxAvgSalaryDeptName = department.getName();
                maxDeptAvgSalary = avgSalary;
            }
        }
        return maxAvgSalaryDeptName;
    }
}
