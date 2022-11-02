package com.Favourite_Movies.Service;

import com.Favourite_Movies.Exceptions.MovieAlreadyExistsException;
import com.Favourite_Movies.Exceptions.MovieNotFoundException;
import com.Favourite_Movies.Model.Movie;

import java.util.List;

public interface MovieService {
    Movie saveFavourite(Movie movie) throws MovieAlreadyExistsException;
    List<Movie> findMoviesByEmail(String email);
    Movie findByMovieId(String movieId);
    boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException;
}
