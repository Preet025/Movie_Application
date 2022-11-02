package com.niit.UserAuthentication.controller;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.InvalidCredentialsException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import com.niit.UserAuthentication.security.SecurityTokenGenerator;
import com.niit.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    public UserController() {
    }

//    @PostMapping("/user")
//    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException
    {
        User retrievedUser = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
