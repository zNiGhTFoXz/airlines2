package project.controller;

import core.controller.Controller;
import core.entity.Entity;
import core.interfaces.IController;
import project.model.FlightModel;
import project.view.flight.FlightMainView;

import java.util.List;
import java.util.Map;

public class FlightController extends Controller implements IController{

    public FlightController(){
        this.model = new FlightModel();
    }

    @Override
    public Map<String, Map<String, String>> init() {
        List<Entity> listOfFlights = this.model.loadAll();
        FlightMainView view = new FlightMainView();
        view.init(listOfFlights);
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
