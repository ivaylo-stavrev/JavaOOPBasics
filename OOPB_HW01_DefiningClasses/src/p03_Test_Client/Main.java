package p03_Test_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> ids = new HashMap<>();
        double amount;
        int id;
        BankAccount acc;
        String line = reader.readLine();

        while (true){
            if("End".equals(line)){
                break;
            }

            String[] cmdArgs = line.split(" ");
            // id = Integer.parseInt(cmdArgs[1]);
            switch (cmdArgs[0]) {
                case "Create":
                    id = Integer.parseInt(cmdArgs[1]);
                    if (ids.containsKey(id)) {
                        System.out.println("Account already exists");
                    }
                    else {
                        acc = new BankAccount();
                        acc.setId(id);
                        ids.put(id, acc);
                    }
                    break;
                case "Deposit":
                    id = Integer.parseInt(cmdArgs[1]);
                    amount = Double.parseDouble(cmdArgs[2]);
                    acc = ids.get(id);
                    if(acc != null) {
                        acc.deposit(amount);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Withdraw":
                    id = Integer.parseInt(cmdArgs[1]);
                    amount = Double.parseDouble(cmdArgs[2]);
                    acc = ids.get(id);
                    if(acc != null) {
                        acc.withdraw(amount);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Print":
                    id = Integer.parseInt(cmdArgs[1]);
                    acc = ids.get(id);
                    if(acc != null) {
                        acc.print(id);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            line = reader.readLine();
        }
    }
}
