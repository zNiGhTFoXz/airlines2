package core.view;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

public abstract class View {
    public void clear(){
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {

        }
    }
}
