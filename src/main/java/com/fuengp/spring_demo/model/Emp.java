package com.fuengp.spring_demo.model;

import java.awt.dnd.DropTarget;
import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    private Long id;
    private String name ;
    private Date birthday ;
    public Emp(){}
    public Emp(Long id , String name , Date birthaday){
        this.id = id ;
        this.name = name ;
        this.birthday = birthaday ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
