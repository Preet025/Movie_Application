package com.User_Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "USER ALREADY EXISTS")
public class UserAlreadyExistsException extends Throwable {
}
