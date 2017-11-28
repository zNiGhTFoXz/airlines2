package project.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;
import project.entity.Route;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RouteModel extends Model implements IModel{
    private Path path = Paths.get("RouteDir/");
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
    public Entity load(String uuid) {
        //try {
            if(!Files.isDirectory(path)) {
                return null;
            }

             try {
                    FileInputStream fis = new FileInputStream(path + uuid + ".out");
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    Route route = (Route) oin.readObject();

                    return route;
                }catch (Exception exp){
                    return null;
                }
    }

    @Override
    public List<Entity> loadAll(){
        if(!Files.isDirectory(this.path)){
            return new ArrayList<>();
        }

        File path = new File(this.path.toString());
        File[] listOfFiles = path.listFiles();

        for(File file : listOfFiles){
            if(file.isFile()){
                String fname = file.getName().substring(0, file.getName().indexOf('.'));
            }
        }

        return null;
    }

    public void delete(String uuid){}
    public boolean update(Map<String, String> params) {
        return false;
    }
}
