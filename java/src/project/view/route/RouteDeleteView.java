package project.view.route;

import core.view.View;

import java.util.Scanner;

public class RouteDeleteView extends View {

    public String success(){
        System.out.println("Successful deleted!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();

        return "Route/get";
    }

    public String error(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).next();

        return "Route/get";
    }
}
