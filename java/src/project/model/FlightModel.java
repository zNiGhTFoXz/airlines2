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
import java.util.UUID;


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
    public Entity load(String uuid) {
        try {
            File dir = new File("C://FlightDir/");
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(uuid + "_");
                }
            });

            for (File file:files) {
                FileInputStream fis = new FileInputStream(file.getPath());
                ObjectInputStream oin = new ObjectInputStream(fis);
                Flight flight = (Flight) oin.readObject();
                System.out.println("version:" + flight.getVersion());
            }
            //FileInputStream fis = new FileInputStream("Flight/file.out");

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
