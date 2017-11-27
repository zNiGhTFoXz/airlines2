package project.view;

import core.interfaces.IView;
import core.view.View;

import java.util.HashMap;
import java.util.Map;

public class MenuView extends View implements IView {
    @Override
    public void print(String tpl, String[] params, boolean newLine) {
        if (newLine){
            System.out.printf(tpl + "\n", params);
        }else{
            System.out.printf(tpl, params);
        }
    }

    public Map<String, Map<String, String>> init(){
        String tpl = "\t[%s]: %s";

        clear();
        print("\t\t--- # %s # ---\n", new String[]{ "Menu" }, true);

        Map<String, Map<String, String>> actions = new HashMap<>();

        Map<String, String> action1 = new HashMap<>();
        action1.put("location","route/init");
        action1.put("title", "Route");

        Map<String, String> action2 = new HashMap<>();
        action2.put("location","flight/init");
        action2.put("title", "Flight");

        Map<String, String> action3 = new HashMap<>();
        action3.put("location", "menu/exit");
        action3.put("title", "Exit");

        actions.put("1", action1);
        actions.put("2", action2);
        actions.put("3", action3);

        for(Map.Entry<String, Map<String, String>> entry : actions.entrySet()) {
            String key = entry.getKey();
            Map<String, String> value = entry.getValue();

            print(tpl, new String[]{ key,value.get("title") }, true);
        }

        return actions;
    }
}
