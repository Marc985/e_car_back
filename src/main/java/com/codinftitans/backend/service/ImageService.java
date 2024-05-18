package com.codinftitans.backend.service;

import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.CarPicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    CarPicRepository productPicRepository;
    @Transactional
    public String saveImageToStorage( MultipartFile imageFile,int idProduct) throws IOException {
        String uploadDirectory="src/main/resources/static/images";
        String uniqueFileName= UUID.randomUUID().toString();
        Path uploadPath=Path.of(uploadDirectory);
        Path filePath=uploadPath.resolve(uniqueFileName);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Files.copy(imageFile.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        saveImageToDb(uniqueFileName,idProduct);
        return  uniqueFileName;
    }
    private void saveImageToDb(String name,int idProduct){
        CarPic pic=new CarPic();
        pic.setUrl(name);
        pic.setIdCar(idProduct);
        productPicRepository.save(pic);
    }

    public byte [] getImage(String imageName) throws IOException {
        String imageDirectory="src/main/resources/static/images";
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
           return  imageBytes;
        } else {
            return null; // Handle missing images
        }
    }
    public String deleteImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return "Success";
        } else {
            return "Failed"; // Handle missing images
        }
    }
}
