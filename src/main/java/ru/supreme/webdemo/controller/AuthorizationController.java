package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.service.UserService;

import javax.servlet.http.HttpSession;

import static ru.supreme.webdemo.WebDemoConst.USER_SESSION_ATTRIBUTE;

@RestController
@RequestMapping("/auth")

public class AuthorizationController {
    private final UserService userService;
    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> userLogin(@RequestBody User user, HttpSession httpSession) {
        Object sessionUserContext = httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (sessionUserContext != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already authenticated");
        }
        if (userService.checkAuth(user) == true) {
            httpSession.setAttribute(USER_SESSION_ATTRIBUTE, user);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
    }
    
    @PostMapping (value = "logout")
    public ResponseEntity<?> logout(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }
        httpSession.invalidate();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "me")
    public ResponseEntity<?> me(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }

        System.out.println(user.getUsername());

        return ResponseEntity.ok(user);
    }
    @PostMapping(value = "registr")
    public ResponseEntity<?> registration(@RequestBody User user) {
        if (userService.registration(user)) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
       else {
           return ResponseEntity.status((HttpStatus.CONFLICT)).build();
        }
    }
}
