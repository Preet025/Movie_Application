package com.Favourite_Movies.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "MOVIE ALREADY EXISTS IN THE FAVOURITE LIST")
public class MovieAlreadyExistsException extends Exception{
}
