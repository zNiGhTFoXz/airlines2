package core.interfaces;

import java.util.Map;

public interface IController {
    Map<String, Map<String, String>> init();

    Map<String, Map<String, String>> get();
    Map<String, Map<String, String>> get(String id);

    Map<String, Map<String, String>> create();
    Map<String, Map<String, String>> delete(String id);
    Map<String, Map<String, String>> update(String id);

    void setLastAction(String lastAction);
}
