package com.movies.royal.service;

import com.movies.royal.model.Movie;
import com.movies.royal.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        movieRepository.save(movie);

        try {
            multipartFile.transferTo(
                    new File(image_save_dest
                            + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Movie getMovieById(long id) {
        return movieRepository.getById(id);
    }

    public void deleteMovieById(long id) {

        try {
            Files.deleteIfExists(
                    Paths.get(image_save_dest
                                    +movieRepository.getById(id).getPoster_name())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        movieRepository.getById(id);

    }
}
