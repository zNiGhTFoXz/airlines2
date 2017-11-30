package project.view.flight;

import core.entity.Entity;
import core.interfaces.IView;
import core.view.View;
import project.entity.Flight;
import project.entity.Route;
import project.helpers.property.FlightProperty;

import java.util.Scanner;

public class FlightShowView extends View implements IView {
    @Override
    public void print(String tpl, String[] params, boolean newLine) {

    }

    public String init(Flight flight){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("[UUID]: %s\t", flight.getUUID());
        System.out.printf("[Number]: %s\t", flight.getNumber());
        System.out.printf("[Airbus]: %s\t", flight.getAirbus());
        System.out.printf("[Time From]: %s\t", flight.getTimeFrom());
        System.out.printf("[Time Path]: %s\t", flight.getTimePath());

        Route route = flight.getRoute();
        if(route == null){
            System.out.printf("[Route]: %s\t", null);
        }else{
            System.out.print("\n\t\tRoute: ");

            System.out.printf("[UUID]: %s\t", route.getUUID());
            System.out.printf("[From]: %s\t", route.getFlightFrom());
            System.out.printf("[To]: %s", route.getFlightTo());
        }

        System.out.println();

        System.out.println("\nMenu:");
        System.out.println("[1] - Edit");
        System.out.println("[2] - Delete");
        System.out.println("[0] - Back");

        int b = scanner.nextInt();
        while(b < 0 || b > 2) {
            System.out.println("Incorrect value");
            b = scanner.nextInt();
        }
        switch (b) {
            case 1:
                return "Flight/update";
            case 2:
                return "Flight/delete?"+FlightProperty.UUID+"="+flight.getUUID().toString();
            case 0:
                return "Flight/init";
        }
        return null;
    }
}
