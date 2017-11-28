package project.view.flight;

import core.entity.Entity;
import core.interfaces.IView;
import core.view.View;
import project.entity.Flight;
import project.entity.Route;

import java.util.List;
import java.util.Map;

public class FlightMainView extends View implements IView{

    public FlightMainView(){

    }

    @Override
    public void print(String tpl, String[] params, boolean newLine) {
    }

    public Map<String, Map<String, String>> init(List<Entity> list){
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
                System.out.printf("[Route]: %s\t", null);
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
        System.out.println("[2] - Edit By ID");
        System.out.println("[0] - Back");

        System.out.println("\n*Type action number and data (if needed) with whitespace as divider*\n");

        return null;
    }
}
