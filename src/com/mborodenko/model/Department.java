package com.mborodenko.model;

public class Department {

    private int departmentid;
    private String name;

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + departmentid + ", name=" + name + "]";
    }
}
