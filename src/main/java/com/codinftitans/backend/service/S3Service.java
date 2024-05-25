package com.codinftitans.backend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.CarPicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    private final AmazonS3 s3client;
    @Autowired
    private  CarPicRepository carPicRepository;

    @Value("${aws.s3.bucket}")
    private String bucketName;
    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }


    public void uploadFile(UUID idCar,String keyName, MultipartFile file) throws IOException {
        var putObjectResult = s3client.putObject(bucketName, keyName, file.getInputStream(), null);
        var appUrl=System.getenv("APP_URL");
        var imageUrl=appUrl+"/view/"+keyName;

        saveImageToDb(imageUrl,idCar);


    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }
    private void saveImageToDb(String name, UUID idProduct){
        CarPic pic=new CarPic();
        pic.setUrl(name);
        pic.setIdCar(idProduct);
        carPicRepository.save(pic);
    }
}

