package project.view;

import core.view.View;

import java.util.Scanner;

public class MenuView extends View{

    public MenuView(){

    }

    public String init(){
        System.out.println("--- # Menu # ---\n");
        System.out.println("[1]: Route");
        System.out.println("[2]: Flight");
        System.out.println("[0]: Exit");

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Type action ID: ");
            try {
                int b = scanner.nextInt();
                if (b < 0 || b > 2) {
                    System.out.println("Incorrect value");
                } else {
                    switch (b) {
                        case 1:
                            return "Route/init";
                        case 2:
                            return "Flight/init";
                        case 0:
                            System.exit(0);
                    }
                }
            }catch (Exception exp){
                break;
            }
        }while (true);

        return "menu/init";
    }
}
