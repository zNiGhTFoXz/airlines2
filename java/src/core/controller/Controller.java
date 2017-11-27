package core.controller;

import core.interfaces.IModel;

public abstract class Controller{
    protected IModel model;

    public IModel getModel() {
        return model;
    }

    public void setModel(IModel model) {
        this.model = model;
    }
}
