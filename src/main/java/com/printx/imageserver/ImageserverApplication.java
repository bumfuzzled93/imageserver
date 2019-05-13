package com.printx.imageserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageserverApplication {

    public static void main(String[] args) {
        System.out.println( java.lang.System.currentTimeMillis() );

        SpringApplication.run(ImageserverApplication.class, args);
    }

}
