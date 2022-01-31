package com.movies.royal.service;

import com.movies.royal.model.Movie;
import com.movies.royal.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private String image_save_dest = "C:\\Users\\Rustam\\Desktop\\" +
            "Developia\\FINAL PROJECTS\\" +
            "BACKEND PROJECT\\easy project\\" +
            "royal\\image_base\\";

    public List<Movie> getMovieList(){
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie, MultipartFile multipartFile) {
        movie.setPoster_name(multipartFile.getOriginalFilename());

        try {
            multipartFile.transferTo(
                    new File(image_save_dest
                            + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
