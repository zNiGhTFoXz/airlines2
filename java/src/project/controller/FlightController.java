package project.controller;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.controller.Controller;
import core.interfaces.IController;
import project.model.FlightModel;

import java.util.Map;

public class FlightController extends Controller implements IController{

    public FlightController(){
        this.model = new FlightModel();
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
