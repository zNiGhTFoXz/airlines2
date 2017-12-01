package project.controller;

import core.controller.Controller;
import core.interfaces.IController;
import project.model.MenuModel;
import project.view.MenuView;

import java.util.HashMap;

public class MenuController extends Controller implements IController{

    public MenuController(){
        this.model = new MenuModel();
    }

    @Override
    public String get() {
        MenuView menu = new MenuView();

        return menu.init();
    }

    @Override
    public String get(HashMap<String, String> params) {
        return null;
    }

    @Override
    public String create() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete(HashMap<String, String> params) {
        return null;
    }

    @Override
    public String update(HashMap<String, String> params) {
        return null;
    }

    @Override
    public String create(HashMap<String, String> params) {
        return null;
    }
}
