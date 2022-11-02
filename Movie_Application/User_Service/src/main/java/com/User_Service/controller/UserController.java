package com.User_Service.controller;


import com.User_Service.domain.User;
import com.User_Service.exception.UserAlreadyExistsException;
import com.User_Service.exception.UserNotFoundException;
import com.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private UserService userService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            responseEntity =  new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }
    @GetMapping("/registers/{email}")
    public ResponseEntity<?> getUserbyEmail(@PathVariable String email) throws UserNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
}

