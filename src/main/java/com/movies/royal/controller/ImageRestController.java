package com.movies.royal.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/movie_poster")
public class ImageRestController {

    private String image_save_dest = "C:\\Users\\Rustam\\Desktop\\" +
            "Developia\\FINAL PROJECTS\\" +
            "BACKEND PROJECT\\easy project\\" +
            "royal\\image_base\\";

    @GetMapping(
            value = "/getPoster/{posterName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImage(
            @PathVariable("posterName") String posterName
    ){
        System.out.println(posterName);
        File file;
        InputStream in;
        try {
            file = new File(
                    image_save_dest+posterName);
            in = new FileInputStream(file);
            return IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
            file = new File(
                    "C:\\Users\\Rustam\\" +
                            "Desktop\\Developia\\" +
                            "FINAL PROJECTS\\BACKEND PROJECT\\" +
                            "easy project\\royal\\royal\\" +
                            "src\\main\\resources\\static\\" +
                            "images\\poster_not_found.jpg");
            try {
                in = new FileInputStream(file);
                return IOUtils.toByteArray(in);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
