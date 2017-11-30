package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.entity.Route;
import project.model.RouteModel;

import java.util.List;
import java.util.Map;

public class RouteController extends Controller implements IController{

    public RouteController(){
        this.model = new RouteModel();
    }

    @Override
    public String init() {
        List<Entity> listOfRoutes = this.model.loadAll();
        return  null;
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
}
