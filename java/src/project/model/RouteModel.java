package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Route;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RouteModel extends Model implements IModel{
    private Path path = Paths.get("C://RouteDir/");
    @Override
    public void save(Entity obj) {
        try {
            String filename = obj.getUuid().toString();
            if(!Files.isDirectory(path)) {
                Files.createDirectory(path);
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
            FileInputStream fis = new FileInputStream("file.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Route route = (Route) oin.readObject();
            System.out.println("version:" + route.getVersion());
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
