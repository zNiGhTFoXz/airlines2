package project.model;


import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;
import project.entity.Route;
import project.helpers.property.FlightProperty;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class FlightModel extends Model implements IModel {
    private Path path;
    private String divider;
    private String ext;

    public FlightModel() {
        this.path = Paths.get("C://FlightDir/");
        this.divider = "_";
        this.ext = ".out";
    }

    @Override
    public void save(Entity obj) {

            String filename = obj.getUuid().toString() + this.divider;
            if (!Files.isDirectory(path)) {
                try {
                    Files.createDirectory(path);
                } catch (IOException exp){
                    return; //TODO доделать
                }
            }
            if (((Flight) obj).getRoute() != null) {
                filename += ((Flight) obj).getRoute().getUuid().toString();
            }

            try {
                writeObject(this.path + filename + this.ext, obj);
            } catch (IOException exp){
                return; //TODO доделать
            }

    }

    @Override
    public Entity load(String uuid) {
        if (!Files.isDirectory(path)){
            return null;
        }

        File[] files = getFilesByMask(this.path.toString(), uuid);

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
        return null;
    }

    private File[] getFilesByMask(String path, String uuid){
        File dir = new File(path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(uuid + divider);
            }
        });
        return files;
    }

    public void delete(String uuid) {
        File[] files = getFilesByMask(this.path.toString(), uuid);

        for (File file : files) {
            if (!file.delete()) {
                //TODO доделать
            }

        }
    }

    public boolean update(Map<String, String> params) {

        if (!Files.isDirectory(path)) {
            return false;
        }
        String uuid = params.get(FlightProperty.UUID);

        File[] files = getFilesByMask(this.path.toString(), uuid);

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
