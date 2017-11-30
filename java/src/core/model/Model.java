package core.model;

import core.entity.Entity;

import java.io.*;

public abstract class Model {
    protected void writeObject(String path, Entity obj) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    protected Entity readObject(String path) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(fis);

        return (Entity) oin.readObject();
    }
}
