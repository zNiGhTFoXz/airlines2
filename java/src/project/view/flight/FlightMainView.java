package project.view.flight;

import core.entity.Entity;
import core.view.View;
import project.entity.Flight;
import project.entity.Route;
import project.helpers.property.FlightProperty;

import java.util.List;
import java.util.Scanner;

public class FlightMainView extends View {

    public FlightMainView(){

    }

    public String init(List<Entity> list){
        System.out.println("-- # FLIGHTS # --\n");

        if(list.isEmpty()){
            System.out.println("-- FLIGHTS IS EMPTY -- \n");
        }

        for(int i = 0; i < list.size(); i++){
            Flight flight = (Flight)list.get(i);

            System.out.printf("[ID]: %s\t", (i+1));
            System.out.printf("[UUID]: %s\t", flight.getUUID());
            System.out.printf("[Number]: %s\t", flight.getNumber());
            System.out.printf("[Airbus]: %s\t", flight.getAirbus());
            System.out.printf("[Time From]: %s\t", flight.getTimeFrom());
            System.out.printf("[Time Path]: %s\t", flight.getTimePath());

            Route route = flight.getRoute();
            if(route == null){
                System.out.printf("[Route]: %s\t", "null");
            }else{
                System.out.print("\n\t\tRoute: ");

                System.out.printf("[UUID]: %s\t", route.getUUID());
                System.out.printf("[From]: %s\t", route.getFlightFrom());
                System.out.printf("[To]: %s", route.getFlightTo());
            }
            System.out.println();
        }

        System.out.println("\nMenu:");
        System.out.println("[1] - Create New");
        System.out.println("[2] - Show By ID");
        System.out.println("[0] - Back");

        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        while (b<0 || b > 2){
            System.out.println("Incorrect value");
            b = scanner.nextInt();
        }

        switch (b) {
            case 1:
                return "Flight/create";
            case 2:
                System.out.println("Type ID: ");
                do {
                    b = scanner.nextInt();
                }while (b<1 && b>list.size());
                return "Flight/get?"+FlightProperty.UUID+"="+list.get(b-1).getUUID();
            case 0:
                return "menu/init";
        }

        return "Flight/get";
    }
}
