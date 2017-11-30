package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Route;
import project.helpers.property.RouteProperty;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteModel extends Model implements IModel{
    private String path;
    private String ext;
    private String divider;

    public RouteModel() {
        this.path = "RouteDir/";
        this.ext = ".out";
        this.divider = "";
    }

    @Override
    public boolean create(final Map<String, String> params) {
        Route route = new Route();

        if(params.containsKey(RouteProperty.FLIGHT_FROM)){
            route.setFlightFrom(params.get(RouteProperty.FLIGHT_FROM));
        }

        if(params.containsKey(RouteProperty.FLIGHT_TO)){
            route.setFlightTo(params.get(RouteProperty.FLIGHT_TO));
        }

        return save(route);
    }

    @Override
    public boolean save(final Entity obj) {
        String filename = obj.getUUID() + this.divider;

        if(!Files.isDirectory(Paths.get(this.path))) {
            try {
                Files.createDirectory(Paths.get(path));
            } catch (IOException exp) {
                return false; //Error. Can't create directory
            }
        }

        try {
            writeObject(path + filename + this.ext, obj);
        } catch (IOException exp){
            return false; //Error while trying to write a file
        }

        return true;
    }

    @Override
    public Entity load(final Map<String, String> params) {
        if(!params.containsKey(RouteProperty.UUID)){
            return null;
        }

        if (!Files.isDirectory(Paths.get(this.path))){
            return null; //Error. Can't load from non existing directory
        }

        File[] files = getFilesByMask(params.get(RouteProperty.UUID));

        if(files.length > 0){
            Route route;
            try {
                route = (Route) readObject(files[0].getPath());
                return route;
            } catch (Exception exp) {
                return null; //Error while trying to read from a file
            }
        }

        return null; //Files was not found
    }

    @Override
    public List<Entity> loadAll(){
        if(!Files.isDirectory(Paths.get(this.path))){
            return null; //Can't load files from non existing directory
        }

        List<Entity> list = new ArrayList<>();

        File path = new File(this.path);
        File[] listOfFiles = path.listFiles();

        for(File file : listOfFiles){
            if(file.isFile()){
                //filename without extension
                String filename = file.getName().substring(0, file.getName().indexOf('.'));
                Map<String, String> params = new HashMap<>();
                params.put(RouteProperty.UUID, filename);
                Entity routeObject = load(params);
                if(routeObject != null){
                    list.add(routeObject);
                }
            }
        }

        return list;
    }

    @Override
    public File[] getFilesByMask(final String uuid){
        if(!Files.isDirectory(Paths.get(this.path))){
            return new File[]{}; //Can't get files from non existing directory
        }

        File dir = new File(this.path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(uuid);
            }
        });

        return files;
    }

    @Override
    public boolean delete(final Map<String, String> params){
        if(!params.containsKey(RouteProperty.UUID)){
            return false;
        }

        File[] files = getFilesByMask(params.get(RouteProperty.UUID));

        if(files.length > 0){
            return files[0].delete();
        }

        return false;
    }

    @Override
    public boolean update(final Map<String, String> params) {
        if (!Files.isDirectory(Paths.get(this.path))) {
            return false;
        }

        String uuid;

        if(params.containsKey(RouteProperty.UUID)){
            uuid = params.get(RouteProperty.UUID);
        }else {
            return false; //Error. Can't update file without uuid
        }

        File[] files = getFilesByMask(uuid);

        for(File file : files){
            Route route;
            try{
                route = (Route) readObject(file.getPath());
            } catch (Exception exp) {
                return false;
            }

            if (params.containsKey(RouteProperty.FLIGHT_FROM)){
                route.setFlightFrom(params.get(RouteProperty.FLIGHT_FROM));
            }
            if (params.containsKey(RouteProperty.FLIGHT_TO)){
                route.setFlightTo(params.get(RouteProperty.FLIGHT_TO));
            }
        }

        return true;
    }
}
