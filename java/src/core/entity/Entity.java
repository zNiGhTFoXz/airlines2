package core.entity;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {
    private long version;
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Entity(){
        this.version = 13L;
        this.uuid = UUID.randomUUID();
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
