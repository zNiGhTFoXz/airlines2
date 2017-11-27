package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;
import project.entity.Route;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class FlightModel extends Model implements IModel {
    private Path path = Paths.get("C://FlightDir/");

    private static String AIRBUS = "";
    private static String NUMBER = "";

    @Override
    public void save(Entity obj) {
        try {
            String filename = obj.getUuid().toString() + "_";
            if(!Files.isDirectory(path)) {
                Files.createDirectory(path);
            }
            if(((Flight)obj).getRoute() != null) {
                filename += ((Flight) obj).getRoute().getUuid().toString();
            }

            FileOutputStream fos = new FileOutputStream(path + filename +".out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }

    }

    @Override
    public Entity load(String uuid) {

        try {
            if(Files.isDirectory(path)) {
                File dir = new File("C://FlightDir/");
                File[] files = dir.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.matches(uuid + "_");
                    }
                });

                for (File file : files) {
                    FileInputStream fis = new FileInputStream(file.getPath());
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    Flight flight = (Flight) oin.readObject();
                    System.out.println("version:" + flight.getVersion());
                }

            }
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Entity> loadAll() {
        return null;
    }

    public void delete(String uuid) {
        try{
            File dir = new File("C://FlightDir/");
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(uuid + "_");
                }
            });
            for (File file : files) {
                if(file.delete()){
                    System.out.println(file.getName() + "is deleted!");
                } else { System.out.println("Delete operation is failed!"); }
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
    }

    public boolean update(Map<String, String> params) {
        try {
            if(Files.isDirectory(path)) {
                String uuid = params.get("id");

                File dir = new File("C://FlightDir/");
                File[] files = dir.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.matches(uuid + "_");
                    }
                });

                for (File file : files) {
                    FileInputStream fis = new FileInputStream(file.getPath());
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    Flight flight = (Flight) oin.readObject();

                    if(params.get("number") != null) {
                        flight.setNumber(Long.parseLong(params.get("number")));
                    }

                    if(params.get("airbus") != null) {
                        flight.setAirbus(params.get("airbus"));
                    }

                    if(params.get("route") != null) {
                        IModel model = new RouteModel();
                        Route route = (Route) model.load(params.get("route"));
                        flight.setRoute(route);

                    } else { return false; }

                    if(params.get("timefrom") != null) {
                        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
                        Date timeFrom = format.parse(params.get("timefrom"));
                        flight.setTimeFrom(timeFrom);
                    }

                    if(params.get("timepath") != null) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        Date timePath = format.parse(params.get("timepath"));
                        flight.setTimePath(timePath);
                    }
                }

            }
        }
        catch (Exception exp){
            exp.printStackTrace();
        }

    }
}
