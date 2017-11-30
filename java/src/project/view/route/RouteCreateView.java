package project.view.route;

import core.view.View;
import project.helpers.property.RouteProperty;

import java.util.Scanner;

public class RouteCreateView extends View {

    public String init() {
        do {
            System.out.println("---- CREATE ROUTE -----");
            Scanner scanner = new Scanner(System.in); // получаем InputStream

            System.out.print("[Flight from]: ");
            String flightFrom = scanner.next();

            System.out.print("[Flight to]: ");
            String flightTo = scanner.next();

            System.out.println("Result:\n");


            System.out.printf("[Flight from]: %s\t", flightFrom);
            System.out.printf("[Flight to]: %s\t", flightTo);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            while (b < 0 || b > 2) {
                System.out.println("Incorrect value");
                b = scanner.nextInt();
            }
            switch (b) {
                case 1:
                    return "Route/create?" +
                            RouteProperty.FLIGHT_FROM + "=" + flightFrom + "&" +
                            RouteProperty.FLIGHT_TO + "=" + flightTo;
                case 2:
                    break;
                case 0:
                    return "Route/init";
            }
        } while (true);
    }

    public String success() {
        System.out.println("Successful created!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();

        return "Route/init";
    }

    public String error() {
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();

        return "Route/init";
    }
}
