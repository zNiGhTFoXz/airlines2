package core.interfaces;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import java.util.Map;

public interface IController {
    Map<String, String> init();

    Map<String, String> get();
    Map<String, String> get(String id);

    Map<String, String> create();
    Map<String, String> delete(String id);
    Map<String, String> update(String id);

    void setLastAction(String lastAction);
}
