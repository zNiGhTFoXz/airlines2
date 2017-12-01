package project.view.route;

import core.view.View;
import project.entity.Route;
import project.helpers.property.RouteProperty;

import java.util.Scanner;

public class RouteUpdateView extends View {

    public String init(Route route) {
        do {
            System.out.println("---- UPDATE ROUTE -----");
            Scanner scanner = new Scanner(System.in); // получаем InputStream

            System.out.print("[Flight from]: ");
            String flightFrom = scanner.nextLine();

            System.out.print("[Flight to]: ");
            String flightTo = scanner.nextLine();


            System.out.printf("[Flight from]: %s [Flight to]: %s\n", flightFrom, flightTo);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            switch (b) {
                case 1:
                    return "Route/update?"+ RouteProperty.UUID+"="+route.getUUID()+"&"+
                            RouteProperty.FLIGHT_FROM+"="+flightFrom+"&"+
                            RouteProperty.FLIGHT_TO+"="+flightTo;
                case 2:
                    break;
                case 0:
                    return "Route/get?" + RouteProperty.UUID + "=" + route.getUUID();
            }

        } while (true);
    }

    public String error(){
        System.out.println("Error!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Route/get";
    }

    public String success(){
        System.out.println("Success!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Route/get";
    }
}
