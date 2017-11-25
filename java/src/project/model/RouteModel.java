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
import java.util.List;

public class RouteModel extends Model implements IModel{
    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Route route = new Route();
            oos.writeObject(route);
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
