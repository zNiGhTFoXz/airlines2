package project.view.route;

import core.view.View;
import project.entity.Route;
import project.helpers.property.RouteProperty;

import java.util.Scanner;

public class RouteShowView extends View {

    public String init(Route route){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("[UUID]: %s\t", route.getUUID());
        System.out.printf("[Flight from]: %s\t", route.getFlightFrom());
        System.out.printf("[Flight to]: %s\t", route.getFlightTo());

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
                return "Route/update";
            case 2:
                return "Route/delete?"+ RouteProperty.UUID+"="+route.getUUID().toString();
            case 0:
                return "Route/init";
        }
        return null;
    }
}
