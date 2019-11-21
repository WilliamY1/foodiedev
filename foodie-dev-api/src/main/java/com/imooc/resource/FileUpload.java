package com.imooc.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author WuJunyi
 * @create 2019-11-21 14:26
 **/
@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:file-upload-dev.properties")
public class FileUpload {
    private String imgUserFaceLocation;

    private String imageServerUrl;

    public String getImgUserFaceLocation() {
        return imgUserFaceLocation;
    }

    public void setImgUserFaceLocation(String imgUserFaceLocation) {
        this.imgUserFaceLocation = imgUserFaceLocation;
    }

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }
}
