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

    @Override
    public boolean create(final Map<String, String> params){
        Flight flight = new Flight();

        if (params.containsKey(FlightProperty.NUMBER)) {
            try {
                flight.setNumber(Long.parseLong(params.get(FlightProperty.NUMBER)));
            }catch (Exception exp){
                return false; //Error while parsing long value
            }
        }

        if (params.containsKey(FlightProperty.AIRBUS)) {
            flight.setAirbus(params.get(FlightProperty.AIRBUS));
        }

        if (params.containsKey(FlightProperty.ROUTE)) {
            IModel model = new RouteModel();
            Route route = (Route) model.load(params.get(FlightProperty.ROUTE));
            if (route == null) {
                return false; //Route was presented but not found
            }
            flight.setRoute(route);
        }

        if (params.containsKey(FlightProperty.TIME_FROM)) {
            SimpleDateFormat format = new SimpleDateFormat(FlightProperty.DATE_FORMAT);
            try {
                Date timeFrom = format.parse(params.get(FlightProperty.TIME_FROM));
                flight.setTimeFrom(timeFrom);
            } catch (ParseException exp) {
                return false; //Error while trying to parse date value
            }
        }

        if (params.containsKey(FlightProperty.TIME_PATH)) {
            SimpleDateFormat format = new SimpleDateFormat(FlightProperty.TIME_FORMAT);
            try {
                Date timePath = format.parse(params.get(FlightProperty.TIME_PATH));
                flight.setTimePath(timePath);
            } catch (ParseException exp) {
                return false; //Error while trying to parse time value
            }
        }

        return save(flight); //Create will not successfully completed if save not happen

    }

    @Override
    public boolean save(final Entity obj) {
        String filename = obj.getUUID() + this.divider;

        if (!Files.isDirectory(Paths.get(this.path))) {
            try {
                Files.createDirectory(Paths.get(this.path));
            } catch (IOException exp){
                return false; //Error while trying to create directory
            }
        }

        if (((Flight) obj).getRoute() != null) {
            filename += ((Flight) obj).getRoute().getUUID();
        }

        try {
            writeObject(this.path + filename + this.ext, obj);
        } catch (IOException exp){
            return false; //Error while writing to a file
        }

        return true; //Success save
    }

    @Override
    public Entity load(final String uuid) {
        if (!Files.isDirectory(Paths.get(this.path))){
            return null; //Error. Can't load from non existing directory
        }

        File[] files = getFilesByMask(uuid);

        if(files.length > 0){
            Flight flight;
            try {
                flight = (Flight) readObject(files[0].getPath());
                return flight; //Only one file should be exist
            }catch (Exception exp){
                return null; //Error while trying read from a file
            }
        }

        return null; //Files was not found
    }

    @Override
    public List<Entity> loadAll() {
        List<Entity> list = new ArrayList<>();

        if (!Files.isDirectory(Paths.get(this.path))){
            return list;
        }

        File folder = new File(this.path);
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles){
            if(file.isFile()){
                //uuid_
                String filename= file.getName().substring(0, file.getName().indexOf('_'));
                Entity flightObject = load(filename);
                if(flightObject != null){
                    list.add(flightObject);
                }
            }
        }

        return list;
    }

    @Override
    public File[] getFilesByMask(final String uuid){
        if (!Files.isDirectory(Paths.get(this.path))){
            return new File[]{}; //Error. Can't find files in non existing directory
        }

        File dir = new File(this.path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(uuid + divider);
            }
        });

        return files; //will return null if file was not exist
    }

    @Override
    public boolean delete(final String uuid) {
        File[] files = getFilesByMask(uuid);

        if(files.length > 0){
            return files[0].delete();
        }

        return false; //Error. File can't be deleted if it was not found
    }

    @Override
    public boolean update(final Map<String, String> params) {
        if (!Files.isDirectory(Paths.get(this.path))) {
            return false; //Error. Can't update not existed file in not existed directory
        }

        String uuid;

        if(params.containsKey(FlightProperty.UUID)){
            uuid = params.get(FlightProperty.UUID);
        }else {
            return false; //Error. Can't update file without uuid
        }

        File[] files = getFilesByMask(uuid);

        for (File file : files) {
            Flight flight;
            try {
                flight = (Flight) readObject(file.getPath());
            } catch (Exception exp) {
                return false; //Error while reading from a file
            }

            if (params.containsKey(FlightProperty.NUMBER)) {
                try {
                    flight.setNumber(Long.parseLong(params.get(FlightProperty.NUMBER)));
                }catch (Exception exp){
                    return false; //Error while parsing long value
                }
            }

            if (params.containsKey(FlightProperty.AIRBUS)) {
                flight.setAirbus(params.get(FlightProperty.AIRBUS));
            }

            if (params.containsKey(FlightProperty.ROUTE)) {
                IModel model = new RouteModel();
                Route route = (Route) model.load(params.get(FlightProperty.ROUTE));
                if (route == null) {
                    return false; //Error. Can't update with not existed Route
                }
                flight.setRoute(route);
            }

            if (params.containsKey(FlightProperty.TIME_FROM)) {
                SimpleDateFormat format = new SimpleDateFormat(FlightProperty.DATE_FORMAT);
                try {
                    Date timeFrom = format.parse(params.get(FlightProperty.TIME_FROM));
                    flight.setTimeFrom(timeFrom);
                } catch (ParseException exp) {
                    return false; //Error while trying to parse date
                }

            }

            if (params.containsKey(FlightProperty.TIME_PATH)) {
                SimpleDateFormat format = new SimpleDateFormat(FlightProperty.TIME_FORMAT);
                try {
                    Date timePath = format.parse(params.get(FlightProperty.TIME_PATH));
                    flight.setTimePath(timePath);
                } catch (ParseException exp) {
                    return false; //Error while trying to parse time
                }
            }
        }

        return true; //Successful update
    }
}
