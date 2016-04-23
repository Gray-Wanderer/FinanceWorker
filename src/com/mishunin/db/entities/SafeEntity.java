package com.mishunin.db.entities;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
public abstract class SafeEntity extends BaseEntity {

    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
