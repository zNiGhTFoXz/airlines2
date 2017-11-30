package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.model.FlightModel;
import project.view.flight.FlightCreateView;
import project.view.flight.FlightMainView;

import java.util.List;
import java.util.Map;

public class FlightController extends Controller implements IController{

    public FlightController(){
        this.model = new FlightModel();
    }

    @Override
    public String init() {
        List<Entity> listOfFlights = this.model.loadAll();
        FlightMainView view = new FlightMainView();
        return view.init(listOfFlights);
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
        FlightCreateView view = new FlightCreateView();

        return view.init();
    }

    @Override
    public String create(Map<String, String> params){
        boolean result = this.model.create(params);

        FlightCreateView view = new FlightCreateView();
        if (result) {
            return view.success();
        } else {
            return view.error();
        }
    }

    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public String update(String id) {
        return null;
    }
}
