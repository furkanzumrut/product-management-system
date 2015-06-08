package com.furkanzumrut.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by furkanzumrut on 6/7/15.
 */
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotEmpty
    @Length(max = 50,min = 2)
    protected String firstName;

    @Column(name = "last_name")
    @NotEmpty
    @Length(max = 50,min = 2)
    protected String lastName;

    @NotEmpty
    @Column(name = "age")
    @Max(150)
    @Min(5)
    protected int age;

    @Column(name = "gender")
    protected String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
