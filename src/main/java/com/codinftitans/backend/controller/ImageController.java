package com.codinftitans.backend.controller;

import com.codinftitans.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {
    @Autowired
ImageService imageService;
    @PostMapping("/upload/image")
public String uploadImages(@RequestBody MultipartFile image) throws IOException {
/*for(MultipartFile image:images){
    imageService.saveImageToStorage(image);

}*/
        imageService.saveImageToStorage(image);

return  "uploaded successfully";
}
@GetMapping("/view/image")
public byte [] getImages(@RequestParam(name = "name") String imageName) throws IOException {
        return  imageService.getImage(imageName);
}

}
