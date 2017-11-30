package core.interfaces;

import core.entity.Entity;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IModel {
    boolean create(final Map<String, String> params);
    boolean save(final Entity obj);
    Entity load(final Map<String, String> params);
    List<Entity> loadAll();
    boolean delete(final Map<String, String> params);
    boolean update(final Map<String, String> params);
    File[] getFilesByMask(final String uuid);
}
