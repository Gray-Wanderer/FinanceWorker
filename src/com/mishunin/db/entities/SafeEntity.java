package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
public abstract class SafeEntity extends BaseEntity {

    @Column("CREATE_DATE")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
