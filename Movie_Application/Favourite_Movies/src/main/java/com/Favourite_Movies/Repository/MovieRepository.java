package com.Favourite_Movies.Repository;

import com.Favourite_Movies.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findByMovieId(String movieId);
    List<Movie> findAllMoviesByEmail(String email);
    boolean deleteByMovieIdAndEmail(String movieId,String email);
}
