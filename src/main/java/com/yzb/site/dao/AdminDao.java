package com.yzb.site.dao;

import com.yzb.site.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {
    String TABLE_NAME = "admin";
    String TABLE_CONLUMN = "id,admin_name,admin_password,status";

    /**
     * CRUD
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO admin(admin_name,admin_password,status) VALUES(#{adminName},#{adminPassword},#{status});")
    int addAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE id=#{id};")
    int deleteAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE id=#{id};")
    int deleteById(int id);

    @Update("UPDATE admin SET admin_name=#{adminName},admin_password=#{adminPassword},status=#{status} WHERE id=#{id};")
    int updateAdmin(Admin admin);

    @Select("SELECT COUNT(*) FROM admin;")
    int countAdmin();

    @Select("SELECT * FROM admin WHERE id=#{id};")
    Admin findById(int id);

    @Select("SELECT * FROM admin WHERE admin_name=#{adminName} AND admin_password=#{adminPassword};")
    Admin validAdmin(Admin admin);

    @Select("SELECT * FROM admin WHERE admin_name=#{name};")
    boolean validName(String adminName);

    @Select("SELECT * FROM admin WHERE admin_name=#{name};")
    Admin findByName(String name);

    @Select("SELECT * FROM admin;")
    List<Admin> findAll();

}
