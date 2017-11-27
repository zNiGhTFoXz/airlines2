import project.helpers.LocationParser;
import project.helpers.Router;

public class Main {
    public static void main (String args[]){
        Router router = new Router();
        try {
            router.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        * **************************************
        * # TESTS #
        ****************************************
        */

        // -- # Location Parser Test # --
        //test1();

        /*Route a = new Route();
        System.out.println(a.getUuid().toString());
        System.out.println(a.getVersion());

        Flight b = new Flight();
        System.out.println(b.getUuid().toString());
        System.out.println(b.getVersion());*/

    }

    private static void test1(){
        String [] locations = {
                "controller/action?id=&id2=test2$=test3",
                "controller/action",
                "controller/action?",
                "controller/action?id=test1&id2=test2&id3=test3",
                "controller/action?id=&id2=&id3=test3",
        };

        for(String location : locations) {
            System.out.println("Test for: " + location);
            LocationParser lp = new LocationParser(location);
            try {
                lp.parse();
                System.out.println("Full location: " + lp.getLocation());
                System.out.println("Controller name: " + lp.getControllerName());
                System.out.println("Action name: " + lp.getActionName());
                System.out.println("Query: " + lp.getParams().entrySet());
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
            System.out.println();
        }
    }
}
