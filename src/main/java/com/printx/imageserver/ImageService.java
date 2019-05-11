package com.printx.imageserver;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImageService {

    private static String photofolder = "C:\\images";
    public List<Image> getImages(){
        List<Image> images = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(photofolder))) {
             List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()).collect(Collectors.toList());

             result.forEach( x -> images.add(new Image(String.format("http://localhost:8080/image/%s", x))));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return images;
    }

    public byte[] getImage(String filename) {
        Path p = Paths.get(photofolder + filename);

        try {
            return Files.readAllBytes(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
