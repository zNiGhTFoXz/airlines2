package project.model;

import core.entity.Entity;
import core.interfaces.IModel;
import core.model.Model;

import java.util.List;
import java.util.Map;

public class MenuModel extends Model implements IModel{

    @Override
    public void save(Entity obj) {

    }

    @Override
    public Entity load(String uuid) {
        return null;
    }

    @Override
    public List<Entity> loadAll() {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public boolean update(Map<String, String> params) {
        return false;
    }
}
