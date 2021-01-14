package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.User;
import ru.supreme.webdemo.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")

public class AuthorizationController {
    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> userLogin(@RequestBody User user, HttpSession httpSession) {
        Object sessionUserContext = httpSession.getAttribute("kashka");
        if (sessionUserContext != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already aythenticated");
        }
        if (userService.checkoutAuth(user) == true) {
            httpSession.setAttribute("kashka", user);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Usernamr or Password");
    }

    @GetMapping(value = "logout")
    public ResponseEntity<?> logout(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("kashka");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }
        httpSession.invalidate();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "myUsername")
    public ResponseEntity<?> myUsername(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("kashka");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }

        System.out.println(user.getUsername());

        return ResponseEntity.ok(user);
    }
}
