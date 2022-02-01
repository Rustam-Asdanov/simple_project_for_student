package com.movies.royal.repository;

import com.movies.royal.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    /**
     * SET  @num := 0;
     *
     * UPDATE your_table SET id = @num := (@num+1);
     *
     * ALTER TABLE your_table AUTO_INCREMENT =1;
     */
}
