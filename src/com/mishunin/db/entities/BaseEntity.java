package com.mishunin.db.entities;

import java.util.UUID;

/**
 * Created by Andrey on 18.04.2016.
 */
public abstract class BaseEntity {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
