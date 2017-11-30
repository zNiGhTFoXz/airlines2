package project.helpers;

import core.interfaces.IController;
import project.controller.MenuController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class Router {
    private static final String DEFAULT_CONTROLLER = "menu";//menu
    private static final String DEFAULT_ACTION = "init";//init

    private static final String CONTROLLER_PREFIX = "Controller";
    private static final String CONTROLLER_PACKAGE = "project.controller";

    private String CONTROLLER_NAME;
    private String ACTION_NAME;
    private Map<String, String> PARAMS;

    private IController controller;
    private String location;

    public void start(){
        LocationParser locationParser = new LocationParser();

        do {
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

            try {
                this.controller = getController(CONTROLLER_PACKAGE + "." + CONTROLLER_NAME + CONTROLLER_PREFIX);
            } catch (Exception exp) {
                this.controller = new MenuController();
            }

            try {
                this.location = callAction(this.controller, ACTION_NAME, PARAMS);
            } catch (Exception exp) {
                this.location = new MenuController().init();
            }

            locationParser.setLocation(this.location);

            setProperty("CONTROLLER_NAME", locationParser.getControllerName());
            setProperty("ACTION_NAME", locationParser.getActionName());
            setProperty("PARAMS", locationParser.getParams());
        }while (true);
    }

    private void setProperty(String property, String value){
        switch (property){
            case "CONTROLLER_NAME": {
                this.CONTROLLER_NAME = value;
            } break;
            case "ACTION_NAME": {
                this.ACTION_NAME = value;
            } break;
            default: {
                System.out.println("Unknown property name: " + property);
            } break;
        }
    }

    private void setProperty(String property, Map<String, String> value){
        switch (property){
            case "PARAMS": {
                this.PARAMS = value;
            } break;
            default: {
                System.out.println("Unknown property name: " + property);
            } break;
        }
    }

    private String prepareControllerName(final String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private IController getController(final String controller) throws Exception{
        Class c = Class.forName(controller);
        Object obj = c.newInstance();

        return (IController) obj;
    }

    @SuppressWarnings("unchecked")
    private String callAction(IController controller, final String action, Map<String, String> params) throws Exception{
        if(params != null && !params.isEmpty()) {
            Method method = controller.getClass().getMethod(action, params.getClass());
            return (String) method.invoke(controller, params);
        }else {
            Method method = controller.getClass().getMethod(action);
            return (String) method.invoke(controller);
        }
    }
}
