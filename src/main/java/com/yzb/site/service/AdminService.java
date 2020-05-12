package com.yzb.site.service;

import com.yzb.site.entity.Admin;

import java.util.List;

public interface AdminService {

    Integer addAdmin(Admin admin);

    Integer deleteAdmin(Admin admin);

    Integer deleteById(Integer id);

    Integer updateAdmin(Admin admin);

    Integer countAdmin();

    boolean valildName(String adminName);

    Admin validAdmin(Admin admin);

    Admin findById(Integer id);



    List<Admin> findAll();
}
