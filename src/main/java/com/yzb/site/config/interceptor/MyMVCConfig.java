package com.yzb.site.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

//    @Value("${file.imagesPath}")
    private String mImagesPath = "file:E:\\images\\";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor())
        .addPathPatterns("/admin/**")          //配置拦截路径
        .excludePathPatterns("/admin/login")   //配置可忽略拦截路径
        .addPathPatterns("/user/**")
        .excludePathPatterns("/user/register")
        .excludePathPatterns("/user/login")

        ;
    }

    // 访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (mImagesPath.equals("")) {
            String imagesPath = MyMVCConfig.class.getClassLoader().getResource("").getPath();
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            mImagesPath = imagesPath;
            System.out.println(mImagesPath);
        }
//        LoggerFactory.getLogger(MyWebAppConfigurer.class).info("imagesPath=" + mImagesPath);
        registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
