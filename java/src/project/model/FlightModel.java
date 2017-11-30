package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;
import project.entity.Route;
import project.helpers.property.FlightProperty;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class FlightModel extends Model implements IModel {
    private String path;
    private String divider;
    private String ext;

    public FlightModel() {
        this.path = "FlightDir/";
        this.divider = "_";
        this.ext = ".out";
    }

    public String create(Map<String, String> params){
        Flight flight = new Flight();

        if (params.containsKey(FlightProperty.NUMBER)) {
            flight.setNumber(Long.parseLong(params.get(FlightProperty.NUMBER)));
        }

        if (params.containsKey(FlightProperty.AIRBUS)) {
            flight.setAirbus(params.get(FlightProperty.AIRBUS));
        }

        if (params.containsKey(FlightProperty.ROUTE)) {
            IModel model = new RouteModel();
            Route route = (Route) model.load(params.get(FlightProperty.ROUTE));
            if (route == null) {
                return null;
            }
            flight.setRoute(route);
        }

        if (params.containsKey(FlightProperty.TIME_FROM)) {
            SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
            try {
                Date timeFrom = format.parse(params.get(FlightProperty.TIME_FROM));
                flight.setTimeFrom(timeFrom);
            } catch (ParseException exp) {
                exp.printStackTrace();
            }

        }

        if (params.containsKey(FlightProperty.TIME_PATH)) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            try {
                Date timePath = format.parse(params.get(FlightProperty.TIME_PATH));
                flight.setTimePath(timePath);
            } catch (ParseException exp) {
                exp.printStackTrace();
            }
        }

        save(flight);

        return flight.getUUID().toString();

    }

    @Override
    public void save(Entity obj) {

            String filename = obj.getUUID().toString() + this.divider;
            if (!Files.isDirectory(Paths.get(this.path))) {
                try {
                    Files.createDirectory(Paths.get(this.path));
                } catch (IOException exp){
                    return; //TODO доделать
                }
            }
            if (((Flight) obj).getRoute() != null) {
                filename += ((Flight) obj).getRoute().getUUID().toString();
            }

            try {
                writeObject(this.path + filename + this.ext, obj);
            } catch (IOException exp){
                return; //TODO доделать
            }

    }

    @Override
    public Entity load(String uuid) {
        if (!Files.isDirectory(Paths.get(this.path))){
            return null;
        }

        File[] files = getFilesByMask(uuid);

        for (File file : files) {
            Flight flight;
            try {
                flight = (Flight) readObject(file.getPath());
                return flight;
            }catch (Exception exp){
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Entity> loadAll() {
        List<Entity> list = new ArrayList<>();

        File folder = new File(this.path);
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles){
            if(file.isFile()){
                String filename= file.getName().substring(0, file.getName().indexOf('_'));
                Entity flightObject = load(filename);
                if(flightObject != null){
                    list.add(flightObject);
                }
            }
        }

        return list;
    }

    private File[] getFilesByMask(String uuid){
        File dir = new File(this.path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(uuid+divider);
            }
        });
        return files;
    }

    public void delete(String uuid) {
        File[] files = getFilesByMask(uuid);

        for (File file : files) {
            if (!file.delete()) {
                //TODO доделать
            }

        }
    }

    public boolean update(Map<String, String> params) {

        if (!Files.isDirectory(Paths.get(this.path))) {
            return false;
        }
        String uuid = params.get(FlightProperty.UUID);

        File[] files = getFilesByMask(uuid);

        for (File file : files) {
            Flight flight;
            try {
                flight = (Flight) readObject(file.getPath());
            } catch (Exception exp) {
                return false;
            }

            if (params.containsKey(FlightProperty.NUMBER)) {
                flight.setNumber(Long.parseLong(params.get(FlightProperty.NUMBER)));
            }

            if (params.containsKey(FlightProperty.AIRBUS)) {
                flight.setAirbus(params.get(FlightProperty.AIRBUS));
            }

            if (params.containsKey(FlightProperty.ROUTE)) {
                IModel model = new RouteModel();
                Route route = (Route) model.load(params.get(FlightProperty.ROUTE));
                if (route == null) {
                    return false;
                }
                flight.setRoute(route);
            }

            if (params.containsKey(FlightProperty.TIME_FROM)) {
                SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
                try {
                    Date timeFrom = format.parse(params.get(FlightProperty.TIME_FROM));
                    flight.setTimeFrom(timeFrom);
                } catch (ParseException exp) {
                    exp.printStackTrace();
                }

            }

            if (params.containsKey(FlightProperty.TIME_PATH)) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                try {
                    Date timePath = format.parse(params.get(FlightProperty.TIME_PATH));
                    flight.setTimePath(timePath);
                } catch (ParseException exp) {
                    exp.printStackTrace();
                }
            }
        }

        return true;
    }
}
