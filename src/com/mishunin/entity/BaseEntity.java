package com.mishunin.entity;

import java.util.UUID;

/**
 * @author mishunin
 * @version $Id$
 */
public class BaseEntity {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
