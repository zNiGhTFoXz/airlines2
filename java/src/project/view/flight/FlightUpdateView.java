package project.view.flight;

import core.view.View;
import project.entity.Flight;
import project.helpers.property.FlightProperty;

import java.util.Scanner;

public class FlightUpdateView extends View {

    public String init(Flight flight) {
        do {
            System.out.println("---- UPDATE FLIGHT -----");
            Scanner scanner = new Scanner(System.in); // получаем InputStream

            System.out.print("[Number]: ");
            String number = scanner.nextLine();

            System.out.print("[Airbus]: ");
            String airbus = scanner.nextLine();

            System.out.print("[Time from]: ");
            String timeFrom = scanner.nextLine();

            System.out.print("[Time path]: ");
            String timePath = scanner.nextLine();

            System.out.print("[Route](UUID): ");
            String route = scanner.nextLine();

            System.out.printf("[Number]: %s [Airbus]: %s [Time from]: %s [Time path]: %s [Route](UUID): %s\n", number, airbus, timeFrom, timePath, route);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            switch (b) {
                case 1:
                    return "Flight/update?" +
                            FlightProperty.UUID + "=" + flight.getUUID() + "&" +
                            FlightProperty.NUMBER + "=" + number + "&" +
                            FlightProperty.AIRBUS + "=" + airbus + "&" +
                            FlightProperty.TIME_FROM + "=" + timeFrom + "&" +
                            FlightProperty.TIME_PATH + "=" + timePath + "&" +
                            FlightProperty.ROUTE + "=" + route;
                case 2:
                    break;
                case 0:
                    return "Flight/get?"+ FlightProperty.UUID + "=" + flight.getUUID();
            }
        } while (true);
    }

    public String error(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }

    public String success(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }
}
