package core.interfaces;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;
import project.entity.Flight;

import java.util.List;

public interface IModel {
    void save(Entity obj);
    Entity load();
    List<Entity> loadAll();
}
