package com.Favourite_Movies.Service;

import com.Favourite_Movies.Exceptions.MovieAlreadyExistsException;
import com.Favourite_Movies.Exceptions.MovieNotFoundException;
import com.Favourite_Movies.Model.Movie;
import com.Favourite_Movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService{


    private MovieRepository movieRepository;
    private Movie m;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveFavourite(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.findById(movie.getMovieId()).isPresent())
        {
             m=findByMovieId(movie.getMovieId());
            if(movie.getEmail().equals(m.getEmail()))
            {
                throw new MovieAlreadyExistsException();
            }
            return movieRepository.save(movie);

        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie findByMovieId(String movieId){
        System.out.println("movieId"+movieId);
        Movie favourite = movieRepository.findByMovieId(movieId);
        System.out.println(favourite);
        return favourite;
    }



    @Override
    public List<Movie> findMoviesByEmail(String email) {

        return movieRepository.findAllMoviesByEmail(email);
    }

    @Override
    public boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException {
        movieRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }
}

