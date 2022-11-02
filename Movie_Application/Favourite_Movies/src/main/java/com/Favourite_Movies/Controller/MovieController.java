package com.Favourite_Movies.Controller;

import com.Favourite_Movies.Exceptions.MovieAlreadyExistsException;
import com.Favourite_Movies.Exceptions.MovieNotFoundException;
import com.Favourite_Movies.Model.Movie;
import com.Favourite_Movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/")
@CrossOrigin("http://localhost:4200")
public class MovieController {

    private MovieService movieService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("favourite")
    public ResponseEntity<?> saveFavourite(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        return new ResponseEntity<>(movieService.saveFavourite(movie), HttpStatus.CREATED);
    }

    @GetMapping("favourite/{email}")
    public ResponseEntity<?> getFavouriteMoviesByEmail(@PathVariable String email)
    {
        return new ResponseEntity<>(movieService.findMoviesByEmail(email), HttpStatus.OK);
    }

    @DeleteMapping("deleteFavourite/{movieId}/{email}")
    public ResponseEntity<?> deleteMovieFromFavourites(@PathVariable String movieId,@PathVariable String email) throws MovieNotFoundException
    {
        try
        {
            responseEntity=new ResponseEntity<>(movieService.deleteMovieFromFavourites(movieId,email),HttpStatus.OK);
        }
        catch(MovieNotFoundException e){
            throw new MovieNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity("ERROR......SOMETHING WENT WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

