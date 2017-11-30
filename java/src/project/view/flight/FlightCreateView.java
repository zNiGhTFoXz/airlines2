package project.view.flight;

import core.interfaces.IView;
import core.view.View;
import project.entity.Flight;

import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import project.helpers.property.FlightProperty;

public class FlightCreateView extends View implements IView {

    @Override
    public void print(String tpl, String[] params, boolean newLine) {

    }

    public String init() {
        boolean flag = true;
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
                        return "Flight/init";
                }

        } while(flag);
        return null;
    }

    public String success(String uuid){
        System.out.println("Successful created " + uuid);
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();
        return "Flight/init";

    }
    public String error(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();
        return "Flight/init";
    }
}
