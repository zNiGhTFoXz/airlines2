package project.view.route;

import core.interfaces.IView;
import core.view.View;
import project.helpers.property.RouteProperty;

import java.util.Scanner;

public class RouteUpdateView extends View implements IView {
    @Override
    public void print(String tpl, String[] params, boolean newLine) {

    }

    public String init(String uuid) {
        boolean flag = true;
        do {
            System.out.println("---- UPDATE ROUTE -----");
            Scanner scanner = new Scanner(System.in); // получаем InputStream

            System.out.print("[Flight from]: ");
            String flightFrom = scanner.next();

            System.out.print("[Flight to]: ");
            String flightTo = scanner.next();


            System.out.printf("%s %s\n", flightFrom, flightTo);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            switch (b) {
                case 1:
                    return "Route/update?"+ RouteProperty.UUID+"="+uuid+"&"+
                            RouteProperty.FLIGHT_FROM+"="+flightFrom+"&"+
                            RouteProperty.FLIGHT_TO+"="+flightTo;
                case 2:
                    return "Route/update";
                case 0:
                    return "Route/init";
            }

        } while (flag);
        return null;
    }
}
