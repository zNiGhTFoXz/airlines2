package project.view.flight;

import core.interfaces.IView;
import core.view.View;
import project.helpers.property.FlightProperty;

import java.util.Scanner;

public class FlightUpdateView extends View implements IView {

    @Override
    public void print(String tpl, String[] params, boolean newLine) {

    }

    public String init(String uuid) {
        boolean flag = true;
        do {
            System.out.println("---- UPDATE FLIGHT -----");
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

            System.out.printf("%s %s %s %s %s\n", number, airbus, timeFrom, timePath, route);

            System.out.println("\nMenu:");
            System.out.println("[1] - Confirm");
            System.out.println("[2] - Decline");
            System.out.println("[0] - Back");

            int b = scanner.nextInt();
            switch (b) {
                case 1:
                    return "Flight/update?"+ FlightProperty.UUID+"="+uuid+"&"+
                            FlightProperty.NUMBER+"="+number+"&"+
                            FlightProperty.AIRBUS+"="+airbus+"&"+
                            FlightProperty.TIME_FROM+"="+timeFrom+"&"+
                            FlightProperty.TIME_PATH+"="+timePath+"&"+
                            FlightProperty.ROUTE+"="+route;
                case 2:
                    return "Flight/update";
                case 0:
                    return "Flight/init";
            }

        } while (flag);
        return null;
    }
}
