package org.hibernate.bugs.pojo2;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class Basic implements Serializable {
    @Id
    private String objectId;

    @Column(columnDefinition = "TEXT")
    private String name;


    public Basic() {}



    public String getObjectId() {
        return this.objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }



    public String getName() {
        return this.name;
    }



    public void setName(String name) {
        this.name = name;
    }




}
