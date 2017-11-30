package core.interfaces;

import java.util.Map;

public interface IController {
    String init();

    String get();
    String get(String id);

    String create();
    String delete(String id);
    String update(String id);
    String create(Map<String, String> params);
}
