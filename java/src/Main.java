/*
** Created by NiGhTFoX on 24.11.2017.
*/

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String DEFAULT_CONTROLLER = "Menu";
    public static String DEFAULT_ACTION = "init";
    public static final String CONTROLLER_PREFIX = "Controller";

    public static String CONTROLLER_NAME = null;
    public static String ACTION_NAME = null;
    public static Map<String, String> params = new HashMap<>();

    public static void main (String args[]){
        /* Location Parser Test */
        /*LocationParser lp = new LocationParser("controller/action?id=&id2=test2$=test3");
        try {
            lp.parse();
            System.out.println(lp.getLocation());
            System.out.println(lp.getControllerName());
            System.out.println(lp.getActionName());
            System.out.println(lp.getParams().entrySet());
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }*/
    }
}
