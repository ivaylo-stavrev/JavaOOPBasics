package ex04_telephony;

public class Smartphone implements Calling, Browsing {
    private String model;

    @Override
    public void browse(String url) {
        if(url.matches(".*\\d.*")) {
            System.out.println("Invalid URL!");
        } else {
            System.out.printf("Browsing: %s!%n", url);
        }
    }

    @Override
    public void call(String number) {
        if(!number.matches("\\d+")) {
            System.out.println("Invalid number!");
        } else {
            System.out.printf("Calling... %s%n", number);
        }
    }
}
