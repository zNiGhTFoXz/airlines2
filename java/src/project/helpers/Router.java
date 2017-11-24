package project.helpers;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.interfaces.IController;
import project.controller.MenuController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static final String DEFAULT_CONTROLLER = "menu";
    private static final String DEFAULT_ACTION = "init";
    private static final String CONTROLLER_PREFIX = "Controller";
    private static final String CONTROLLER_FOLDER = "project.controller";

    private String CONTROLLER_NAME;
    private String ACTION_NAME;
    private Map<String, String> params;

    public void start(){

        if(this.CONTROLLER_NAME == null){
            this.CONTROLLER_NAME = prepareControllerName(DEFAULT_CONTROLLER);
        }

        if(this.ACTION_NAME == null){
            this.ACTION_NAME = DEFAULT_ACTION;
        }

        if(this.params == null){
            this.params = new HashMap<>();
        }

        IController controller;

        try {
            controller = getController(CONTROLLER_FOLDER + "." + this.CONTROLLER_NAME + CONTROLLER_PREFIX);
        }catch (Exception exp){
            controller = new MenuController();
        }

        Map<String, String> listOfActions;

        try {
            listOfActions = callAction(controller, this.ACTION_NAME);
        } catch (Exception e) {
            listOfActions = new MenuController().init();
        }
    }

    private String prepareControllerName(final String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private IController getController(String controller) throws Exception{
        Class c = Class.forName(controller);
        Object obj = c.newInstance();

        return (IController) obj;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> callAction(IController controller, String action) throws Exception{
        Method method = controller.getClass().getMethod(action);

        return (Map<String, String>) method.invoke (controller);
    }
}
