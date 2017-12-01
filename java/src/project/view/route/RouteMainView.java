package project.view.route;

import core.entity.Entity;
import core.view.View;
import project.entity.Route;
import project.helpers.property.RouteProperty;

import java.util.List;
import java.util.Scanner;

public class RouteMainView extends View {

    public RouteMainView(){

    }

    public String get(List<Entity> list){
        System.out.println("-- # ROUTES # --\n");

        if(list == null || list.isEmpty()){
            System.out.println("-- ROUTES IS EMPTY -- \n");
        }

        for(int i = 0; list != null && i < list.size(); i++){
            Route route = (Route) list.get(i);

            System.out.printf("[ID]: %s\t", (i+1));
            System.out.printf("[UUID]: %s\t", route.getUUID());
            System.out.printf("[Flight from]: %s\t", route.getFlightFrom());
            System.out.printf("[Flight to]: %s\t", route.getFlightTo());

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
                return "Route/create";
            case 2:
                System.out.println("Type ID: ");
                do {
                    b = scanner.nextInt();
                }while (b<1 && b>list.size());
                return "Route/get?"+ RouteProperty.UUID+"="+list.get(b-1).getUUID();
            case 0:
                return "Menu/get";
        }

        return "Route/get";
    }
}
