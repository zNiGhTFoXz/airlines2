import project.helpers.LocationParser;
import project.helpers.Router;

public class Main {
    public static void main (String args[]){
        //test1();

        Router router = new Router();
        try {
            router.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1(){
        String [] locations = {
            "Flight/init",
            "Route/init",
            "Route/show?uuid=054d3d7f-a1d8-485c-a3d5-a0c735624982",
            "Flight/show?uuid=0bc17aae-ed78-4d96-8d80-848b2e9e8154",
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
