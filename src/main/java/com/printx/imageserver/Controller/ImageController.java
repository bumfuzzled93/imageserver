package com.printx.imageserver.Controller;

import com.printx.imageserver.Image;
import com.printx.imageserver.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        byte[] image = imageService.getImage(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = "application/JSON")
    public ResponseEntity<String> getImages(@RequestParam("timestamp") Optional<Long> timestamp) {
        List<Image> images = null;
        if(timestamp.isPresent()){
            images = imageService.getImages(timestamp.get());
        }else {
            images = imageService.getImages();
        }
        return new ResponseEntity(images, HttpStatus.OK);
    }
}
