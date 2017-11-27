package project.helpers;

import core.interfaces.IController;
import project.controller.MenuController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class Router {
    private static final String DEFAULT_CONTROLLER = "menu";
    private static final String DEFAULT_ACTION = "init";

    private static final String CONTROLLER_PREFIX = "Controller";
    private static final String CONTROLLER_PACKAGE = "project.controller";

    private String CONTROLLER_NAME;
    private String ACTION_NAME;
    private Map<String, String> PARAMS;

    public void start(){
        LocationParser lp = new LocationParser();

        //do {
            if (CONTROLLER_NAME == null || CONTROLLER_NAME.isEmpty()) {
                CONTROLLER_NAME = prepareControllerName(DEFAULT_CONTROLLER);
            } else {
                CONTROLLER_NAME = prepareControllerName(CONTROLLER_NAME);
            }

            if (ACTION_NAME == null || ACTION_NAME.isEmpty()) {
                ACTION_NAME = DEFAULT_ACTION;
            }

            if (PARAMS == null) {
                PARAMS = new HashMap<>();
            }

            IController controller;

            try {
                controller = getController(CONTROLLER_PACKAGE + "." + CONTROLLER_NAME + CONTROLLER_PREFIX);
            } catch (Exception exp) {
                controller = new MenuController();
            }

            Map<String, Map<String, String>> listOfActions;

            try {
                listOfActions = callAction(controller, ACTION_NAME, PARAMS);
            } catch (Exception e) {
                listOfActions = new MenuController().init();
            }

            String location = actionEventListener(listOfActions);
            lp.setLocation(location);
            lp.parse();

            CONTROLLER_NAME = lp.getControllerName();
            ACTION_NAME = lp.getActionName();
            PARAMS = lp.getParams();
        //}while (true);
    }

    private String actionEventListener(Map<String, Map<String, String>> listOfActions){
        return "menu/init"; /* This is stub */
    }

    private String prepareControllerName(final String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private IController getController(final String controller) throws Exception{
        Class c = Class.forName(controller);
        Object obj = c.newInstance();

        return (IController) obj;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Map<String, String>> callAction(IController controller, final String action, Map<String, String> params) throws Exception{
        if(params != null && !params.isEmpty()) {
            Method method = controller.getClass().getMethod(action, params.getClass());
            return (Map<String, Map<String, String>>) method.invoke(controller, params);
        }else {
            Method method = controller.getClass().getMethod(action);
            return (Map<String, Map<String, String>>) method.invoke(controller);
        }
    }
}
