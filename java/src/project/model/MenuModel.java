package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;

import java.io.File;
import java.util.List;
import java.util.Map;

public class MenuModel extends Model implements IModel{

    @Override
    public boolean create(final Map<String, String> params) {
        return false;
    }

    @Override
    public boolean save(final Entity obj) {
        return false;
    }

    @Override
    public Entity load(final String uuid) {
        return null;
    }

    @Override
    public List<Entity> loadAll() {
        return null;
    }

    @Override
    public boolean delete(final String uuid) {
        return false;
    }

    @Override
    public boolean update(final Map<String, String> params) {
        return false;
    }

    @Override
    public File[] getFilesByMask(final String uuid) {
        return new File[0];
    }
}
