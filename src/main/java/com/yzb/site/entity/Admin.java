package com.yzb.site.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Admin {

    private Integer id;
    private String adminName;
    @JsonIgnore
    private String adminPassword;
    @JsonIgnore
    private Integer status = 1;

    public Admin() {
    }

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public Admin(Integer id, String adminName, String adminPassword, Integer status) {
        this.id = id;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", status=" + status +
                '}';
    }
}
