package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FlightModel extends Model implements IModel {
    private Path path = Paths.get("C://FlightDir/");
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
    public Entity load() {
        try {

            FileInputStream fis = new FileInputStream("Flight/file.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Flight flight = (Flight) oin.readObject();
            System.out.println("version:" + flight.getVersion());
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
}
