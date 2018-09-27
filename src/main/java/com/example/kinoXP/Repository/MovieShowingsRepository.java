package com.example.kinoXP.Repository;

import com.example.kinoXP.Domain.MovieShowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowingsRepository extends CrudRepository<MovieShowing, Long> {
}
