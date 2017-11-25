package core.model;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

public abstract class Model {
    protected String serialisationObjectsFolder;

    public String getSerialisationObjectsFolder() {
        return serialisationObjectsFolder;
    }

    public void setSerialisationObjectsFolder(String serialisationObjectsFolder) {
        this.serialisationObjectsFolder = serialisationObjectsFolder;
    }
}
