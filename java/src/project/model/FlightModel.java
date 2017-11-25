package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Flight;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class FlightModel extends Model implements IModel {
    @Override
    public void save() {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Flight flight = new Flight();
        oos.writeObject(flight);
        oos.flush();
        oos.close();

    }

    @Override
    public Entity load() {

        FileInputStream fis = new FileInputStream("file.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Flight flight = (Flight) oin.readObject();
        System.out.println("version:" + flight.getVersion());

        return null;
    }

    @Override
    public List<Entity> loadAll() {
        return null;
    }
}
