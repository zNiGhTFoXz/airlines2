package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.entity.Route;
import project.helpers.property.RouteProperty;
import project.model.RouteModel;
import project.view.route.*;

import java.util.HashMap;
import java.util.List;

public class RouteController extends Controller implements IController{

    public RouteController(){
        this.model = new RouteModel();
    }

    @Override
    public String get() {
        List<Entity> listOfRoutes = this.model.loadAll();
        RouteMainView view = new RouteMainView();

        return view.init(listOfRoutes);
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
        RouteDeleteView view = new RouteDeleteView();
        boolean result = this.model.delete(params);
        if(result){
            return view.success();
        }else {
            return view.error();
        }
    }

    @Override
    public String update(HashMap<String, String> params) {
        RouteUpdateView view = new RouteUpdateView();
        if(params.size() == 1 && params.containsKey(RouteProperty.UUID)){
            Route obj = (Route) this.model.load(params);

            if(obj == null){
                return view.error();
            }else {
                return view.init(obj);
            }
        }else {
            if(this.model.update(params)){
                return view.success();
            }else {
                return view.error();
            }
        }
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
