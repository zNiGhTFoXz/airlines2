package core.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import project.entity.Flight;

import java.io.*;

public abstract class Model {
    public void writeObject(String path, Entity obj) throws IOException{
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public Entity readObject(String path) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(fis);
        Entity obj = (Entity) oin.readObject();

        return obj;

    }
}
