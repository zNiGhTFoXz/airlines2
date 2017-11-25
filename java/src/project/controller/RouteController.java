package project.controller;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.controller.Controller;
import core.interfaces.IController;
import project.model.RouteModel;

import java.util.Map;

public class RouteController extends Controller implements IController{

    public RouteController(){
        this.model = new RouteModel();
    }

    @Override
    public Map<String, Map<String, String>> init() {
        return null;
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
}
