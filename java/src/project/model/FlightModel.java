package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;

import java.io.*;
import java.util.List;


public class FlightModel extends Model implements IModel {
    @Override
    public void save(Entity obj) {
        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
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
