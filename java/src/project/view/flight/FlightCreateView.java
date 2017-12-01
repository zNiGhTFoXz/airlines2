package project.view.flight;

import core.view.View;
import project.helpers.property.FlightProperty;

import java.util.Scanner;

public class FlightCreateView extends View {

    public String get() {
        do {
            System.out.println("---- CREATE FLIGHT -----");
            Scanner scanner = new Scanner(System.in); // получаем InputStream

            System.out.print("[Number]: ");
            String number = scanner.next();

            System.out.print("[Airbus]: ");
            String airbus = scanner.next();

            System.out.print("[Time from]: ");
            String timeFrom = scanner.next();


            System.out.print("[Time path]: ");
            String timePath = scanner.next();

            System.out.print("[Route](UUID): ");
            String route = scanner.next();

            System.out.println("Result:\n");

            System.out.printf("[Number]: %s\t", number);
            System.out.printf("[Airbus]: %s\t", airbus);
            System.out.printf("[Time From]: %s\t", timeFrom);
            System.out.printf("[Time Path]: %s\t", timePath);
            System.out.printf("[Route](UUID): %s\t", route);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            while(b < 0 || b > 2) {
                System.out.println("Incorrect value");
                b = scanner.nextInt();
            }

            switch (b) {
                case 1:
                    return "Flight/create?" +
                            FlightProperty.NUMBER + "=" + number + "&" +
                            FlightProperty.AIRBUS + "=" + airbus + "&" +
                            FlightProperty.TIME_FROM + "=" + timeFrom + "&" +
                            FlightProperty.TIME_PATH + "=" + timePath + "&" +
                            FlightProperty.ROUTE + "=" + route;
                case 2:
                    break;
                case 0:
                    return "Flight/get";
            }
        } while(true);
    }

    public String success(){
        System.out.println("Successful created!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }

    public String error(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }
}
