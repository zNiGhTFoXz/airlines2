package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Route;
import project.helpers.property.RouteProperty;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class RouteModel extends Model implements IModel{
    private String path;
    private String ext;

    public RouteModel() {
        this.path = "RouteDir/";
        this.ext = ".out";
    }


    @Override
    public String create(Map<String, String> params) {
        return null;
    }

    @Override
    public void save(Entity obj) {

            String filename = obj.getUUID().toString();
            if(!Files.isDirectory(Paths.get(this.path))) {
                try {
                    Files.createDirectory(Paths.get(path));
                } catch (IOException exp) {
                    return; //TODO доделать
                }
            }

            try {
                writeObject(path + filename + this.ext, obj);
            } catch (IOException exp){
                return; //TODO доделать
            }
    }

    @Override
    public Entity load(String uuid) {

            if(!Files.isDirectory(Paths.get(this.path))) {
                return null;
            }

            File[] files = getFilesByMask(uuid);
            for (File file : files){
                Route route;
                try {
                    route = (Route) readObject(file.getPath());
                    return route;
                } catch (Exception exp) {
                    return null;
                }
            }
            return null;
    }

    @Override
    public List<Entity> loadAll(){
        if(!Files.isDirectory(Paths.get(this.path))){
            return new ArrayList<>();
        }
        List<Entity> list = new ArrayList<>();

        File path = new File(this.path);
        File[] listOfFiles = path.listFiles();

        for(File file : listOfFiles){
            if(file.isFile()){
                String fname = file.getName().substring(0, file.getName().indexOf('.'));
                Entity routeObject = load(fname);
                if(routeObject != null){
                    list.add(routeObject);
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
                return name.startsWith(uuid);
            }
        });
        return files;
    }

    public void delete(String uuid){
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

        String uuid = params.get(RouteProperty.UUID);

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
