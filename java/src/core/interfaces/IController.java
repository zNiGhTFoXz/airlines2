package core.interfaces;

import java.util.HashMap;

public interface IController {
    String init();

    String get();
    String get(HashMap<String, String> params);

    String create();
    String update();
    String delete(HashMap<String, String> params);
    String update(HashMap<String, String> params);
    String create(HashMap<String, String> params);
}
