package project.controller;

import core.controller.Controller;
import core.interfaces.IController;
import project.model.MenuModel;
import project.view.MenuView;

import java.util.Map;

public class MenuController extends Controller implements IController{

    public MenuController(){
        this.model = new MenuModel();
    }

    @Override
    public Map<String, Map<String, String>> init() {
        MenuView menu = new MenuView();

        return menu.init();
    }

    @Override
    public Map<String, Map<String, String>> get() {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> get(String id) {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> create() {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> delete(String id) {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> update(String id) {
        return null;
    }

    @Override
    public void setLastAction(String lastAction) {

    }

    public void exit(){
        exit();
    }
}
