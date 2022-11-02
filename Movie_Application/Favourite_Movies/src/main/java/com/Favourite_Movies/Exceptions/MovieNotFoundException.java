package com.Favourite_Movies.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "MOVIE NOT FOUND")
public class MovieNotFoundException extends Exception{
}

