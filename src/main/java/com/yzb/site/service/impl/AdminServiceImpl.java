package com.yzb.site.service.impl;

import com.yzb.site.dao.AdminDao;
import com.yzb.site.entity.Admin;
import com.yzb.site.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Integer addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public Integer deleteAdmin(Admin admin) {
        return adminDao.deleteAdmin(admin);
    }

    @Override
    public Integer deleteById(Integer id) {
        return adminDao.deleteById(id);
    }

    @Override
    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Integer countAdmin() {
        return adminDao.countAdmin();
    }

    @Override
    public boolean valildName(String adminName) {
        return adminDao.validName(adminName);
    }

    @Override
    public Admin validAdmin(Admin admin) {
        return adminDao.validAdmin(admin);
    }

    @Override
    public Admin findById(Integer id) {
        return adminDao.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}
