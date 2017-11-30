package project.view.flight;

import core.interfaces.IView;
import core.view.View;

import java.util.Scanner;

public class FlightDeleteView extends View implements IView {

    @Override
    public void print(String tpl, String[] params, boolean newLine) {

    }

    public String success(String uuid){
        System.out.println("Successful deleted " + uuid);
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
