package core.interfaces;

import core.entity.Entity;

import java.util.List;
import java.util.Map;

public interface IModel {
    void save(Entity obj);
    Entity load(String uuid);
    List<Entity> loadAll();
    void delete(String uuid);
    boolean update(Map<String, String> params);
}
