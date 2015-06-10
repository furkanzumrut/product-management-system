package com.furkanzumrut.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by furkanzumrut on 6/7/15.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    @Length(max = 128,min = 3)
    @NotEmpty
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}