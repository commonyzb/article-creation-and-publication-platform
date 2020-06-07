package com.yzb.site.service;

import com.yzb.site.entity.Admin;

import java.util.List;

public interface AdminService {

    int addAdmin(Admin admin);

    int deleteAdmin(Admin admin);

    int deleteById(int id);

    int updateAdmin(Admin admin);

    int countAdmin();

    boolean valildName(String adminName);

    Admin validAdmin(Admin admin);

    Admin findById(int id);

    List<Admin> findAll();
}
