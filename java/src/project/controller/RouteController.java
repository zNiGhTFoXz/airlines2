package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.entity.Route;
import project.model.RouteModel;
import project.view.route.RouteCreateView;
import project.view.route.RouteMainView;
import project.view.route.RouteShowView;

import java.util.HashMap;
import java.util.List;

public class RouteController extends Controller implements IController{

    public RouteController(){
        this.model = new RouteModel();
    }

    @Override
    public String init() {
        List<Entity> listOfRoutes = this.model.loadAll();
        RouteMainView view = new RouteMainView();

        return view.init(listOfRoutes);
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public String get(HashMap<String, String> params) {
        RouteShowView view = new RouteShowView();
        Route obj = (Route) model.load(params);
        return view.init(obj);

    }

    @Override
    public String create() {
        RouteCreateView view = new RouteCreateView();

        return view.init();
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
        RouteCreateView view = new RouteCreateView();
        boolean result = this.model.create(params);

        if (result){
            return view.success();
        } else {
            return view.error();
        }
    }
}
