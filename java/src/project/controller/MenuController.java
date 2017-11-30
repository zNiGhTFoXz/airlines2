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
    public String init() {
        MenuView menu = new MenuView();

        return menu.init();
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public String get(String id) {
        return null;
    }

    @Override
    public String create() {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public String update(String id) {
        return null;
    }

    @Override
    public String create(Map<String, String> params) {
        return null;
    }

    @Override
    public void setLastAction(String lastAction) {

    }

    public void exit(){
        exit();
    }
}
