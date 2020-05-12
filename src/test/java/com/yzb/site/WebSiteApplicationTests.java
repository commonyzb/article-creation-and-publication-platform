package com.yzb.site;

import com.yzb.site.service.AdminService;
import com.yzb.site.service.ArticleService;
import com.yzb.site.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSiteApplicationTests {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;


    @Test
    public void contextLoads() {
//        Admin admin=new Admin();
//        admin.setAdminName("admin");
//        admin.setAdminPassword(MD5Util.md5("321654"));
//        admin.setStatus(1);
//        Integer status=adminService.addAdmin(admin);
//        System.out.println(status.toString());
//        System.out.println(admin.getId());
//        adminService.updateAdmin(admin);
//        User user = new User();
//        user.setUserName("yzb");
//        String salt=StringUtils.createStringRandom(6);
//        user.setSalt(salt);
//        user.setUserPassword(MD5Util.md5("123456"+salt));
//        userService.addUser(user);



    }


}
