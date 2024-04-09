//package com.example.schoolproject_assignment.common.config;
//
//import jakarta.servlet.MultipartConfigElement;
//import lombok.Value;
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.util.unit.DataSize;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//
//@Configuration
//public class MultipartConfig {
//    private Long maxUploadSize;
//    private Long maxUploadSizePerFile;
//
//    public MultipartResolver multipartResolver() {
//        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
//        return multipartResolver;
//    }
//
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxRequestSize(DataSize.ofBytes(maxUploadSize));
//        factory.setMaxFileSize(DataSize.ofBytes(maxUploadSizePerFile));
//
//        return factory.createMultipartConfig();
//    }
//
//
//}
