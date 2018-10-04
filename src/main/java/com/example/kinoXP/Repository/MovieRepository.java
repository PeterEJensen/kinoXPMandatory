package com.example.kinoXP.Repository;

        import com.example.kinoXP.Domain.Movie;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {


    List<Movie> findAll();
    Movie findMovieById(Long id);
    Movie findMovieByTitle(String title);
}
