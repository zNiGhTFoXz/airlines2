package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.model.RouteModel;
import project.view.route.RouteCreateView;
import project.view.route.RouteMainView;

import java.util.List;
import java.util.Map;

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
    public String get(String id) {
        return null;
    }

    @Override
    public String create() {
        RouteCreateView view = new RouteCreateView();

        return view.init();
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
        RouteCreateView view = new RouteCreateView();
        boolean result = this.model.create(params);

        if (result){
            return view.success();
        } else {
            return view.error();
        }
    }
}
