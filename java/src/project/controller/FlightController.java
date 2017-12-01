package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.model.FlightModel;
import project.view.flight.FlightCreateView;
import project.view.flight.FlightDeleteView;
import project.view.flight.FlightMainView;

import java.util.HashMap;
import java.util.List;

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
    public String get(HashMap<String, String> params) {
        return null;
    }

    @Override
    public String create() {
        FlightCreateView view = new FlightCreateView();

        return view.init();
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String create(HashMap<String, String> params){
        boolean result = this.model.create(params);

        FlightCreateView view = new FlightCreateView();
        if (result) {
            return view.success();
        } else {
            return view.error();
        }
    }

    @Override
    public String delete(HashMap<String, String> params) {
        FlightDeleteView view = new FlightDeleteView();
        boolean result = this.model.delete(params);
        if(result){
            return view.success();
        }else {
            return view.error();
        }
    }

    @Override
    public String update(HashMap<String, String> params) {
        return null;
    }
}
