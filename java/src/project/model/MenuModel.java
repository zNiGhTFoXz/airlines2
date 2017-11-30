package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;

import java.io.File;
import java.util.List;
import java.util.Map;

public class MenuModel extends Model implements IModel{

    @Override
    public boolean create(Map<String, String> params) {
        return false;
    }

    @Override
    public boolean save(Entity obj) {
        return false;
    }

    @Override
    public Entity load(Map<String, String> params) {
        return null;
    }

    @Override
    public List<Entity> loadAll() {
        return null;
    }

    @Override
    public boolean delete(Map<String, String> params) {
        return false;
    }

    @Override
    public boolean update(Map<String, String> params) {
        return false;
    }

    @Override
    public File[] getFilesByMask(String uuid) {
        return new File[0];
    }
}
