package core.interfaces;

import java.util.HashMap;

public interface IController {


    String get();
    String get(HashMap<String, String> params);

    String create();
    String create(HashMap<String, String> params);

    String update();
    String update(HashMap<String, String> params);

    String delete(HashMap<String, String> params);
}
