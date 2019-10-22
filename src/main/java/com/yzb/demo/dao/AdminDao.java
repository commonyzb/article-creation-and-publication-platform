package com.yzb.demo.dao;

import com.yzb.demo.entity.Admin;
import org.apache.ibatis.annotations.*;

import javax.annotation.Generated;
import java.util.List;

public interface AdminDao {
    String TABLE_NAME = "admin";
    String TABLE_CONLUMN = "id,admin_name,admin_password,status";

    /*
     * CRUD
     */
    @Options(useGeneratedKeys = true,keyProperty = "adminId",keyColumn = "id")
    @Insert("INSERT INTO admin(admin_name,admin_password,status) VALUES(#{adminName},#{adminPassword},#{status});")
    Integer addAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE id=#{adminId};")
    Integer deleteAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE id=#{adminId};")
    Integer deleteById(Integer id);

    @Update("UPDATE admin(admin_name,admin_password,status) SET(#{adminName},#{adminPassword},#{status}) WHERE id=#{adminId};")
    Integer updateAdmin(Admin admin);

    @Select("SELECT * FROM admin WHERE id=#{id};")
    Admin findById(Integer id);

    @Select("SELECT * FROM admin WHERE id=#{adminId);")
    Admin findAdmin(Admin admin);

    @Select("SELECT * FROM admin WHERE admin_name=#{name};")
    Admin findByName(String name);

    @Select("SELECT * FROM admin ;")
    List<Admin> findAll();

}
