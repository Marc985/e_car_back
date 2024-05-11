package com.codinftitans.backend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class S3service {
    private AmazonS3 s3client;

    @Value("${aws.s3.bucket}")
    private String bucketName;
    public S3service(AmazonS3 s3client) {
        this.s3client = s3client;
    }


    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        var putObjectResult = s3client.putObject(bucketName, keyName, file.getInputStream(), null);

    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }

}
