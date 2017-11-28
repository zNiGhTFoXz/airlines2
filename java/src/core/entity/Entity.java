package core.entity;

import java.io.Serializable;
import java.util.UUID;

public abstract class Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID uuid;

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public Entity(){
        this.uuid = UUID.randomUUID();
    }

    public long version() {
        return serialVersionUID;
    }
}
