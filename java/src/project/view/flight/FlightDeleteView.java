package project.view.flight;

import core.view.View;

import java.util.Scanner;

public class FlightDeleteView extends View{

    public String success(){
        System.out.println("Successful deleted!");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }

    public String error(){
        System.out.println("Error");
        System.out.println("Press any key!");
        (new Scanner(System.in)).nextLine();

        return "Flight/get";
    }
}
