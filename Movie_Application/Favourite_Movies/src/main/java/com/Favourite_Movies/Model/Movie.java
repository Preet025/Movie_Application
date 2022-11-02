package com.Favourite_Movies.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document
public class Movie {
    @Id
    private String movieId;
    private String email;
    private String movieName;


    public Movie(String movieId, String movieName, String email) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.email = email;

    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

