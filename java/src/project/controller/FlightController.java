package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.entity.Flight;
import project.helpers.property.FlightProperty;
import project.model.FlightModel;
import project.view.flight.*;

import java.util.HashMap;
import java.util.List;

public class FlightController extends Controller implements IController{

    public FlightController(){
        this.model = new FlightModel();
    }

    @Override
    public String get() {
        List<Entity> listOfFlights = this.model.loadAll();
        FlightMainView view = new FlightMainView();
        return view.init(listOfFlights);
    }

    @Override
    public String get(HashMap<String, String> params) {
        FlightShowView view = new FlightShowView();
        Flight obj = (Flight) this.model.load(params);
        return view.get(obj);
    }

    @Override
    public String create() {
        FlightCreateView view = new FlightCreateView();

        return view.get();
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
        FlightUpdateView view = new FlightUpdateView();
        if(params.size() == 1 && params.containsKey(FlightProperty.UUID)){
            Flight obj = (Flight) this.model.load(params);

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
}
