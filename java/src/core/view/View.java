package core.view;

public abstract class View {

    public View(){
        clear();
    }

    public void clear(){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }catch (Exception exp){

        }
    }
}
