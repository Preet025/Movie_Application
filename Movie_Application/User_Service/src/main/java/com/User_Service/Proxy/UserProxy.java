package com.User_Service.Proxy;


import com.User_Service.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "user-authentication-service",url = "localhost:8085")
//public interface UserProxy {
//    @PostMapping("/api/v1/user")
//    public ResponseEntity<?> saveUser(@RequestBody User user);
//}
