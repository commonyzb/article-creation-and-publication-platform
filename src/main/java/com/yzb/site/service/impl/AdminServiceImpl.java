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
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(Admin admin) {
        return adminDao.deleteAdmin(admin);
    }

    @Override
    public int deleteById(int id) {
        return adminDao.deleteById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public int countAdmin() {
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
    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}
