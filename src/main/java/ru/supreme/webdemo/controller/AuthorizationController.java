package ru.supreme.webdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.service.UserService;

import javax.servlet.http.HttpSession;

import static ru.supreme.webdemo.WebDemoConst.USER_SESSION_ATTRIBUTE;

@RestController
@RequestMapping(path = "/auth")
public class AuthorizationController {

    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO, HttpSession httpSession) {
        Object sessionUserContext = httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (sessionUserContext != null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Already authenticated!");
        }
        if (userService.checkAuth(userDTO)) {
            httpSession.setAttribute(USER_SESSION_ATTRIBUTE, userDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Successful authentication");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password!");
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }
        httpSession.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body("Bye-bye!");
    }

    @GetMapping
    public ResponseEntity<?> userInfo(HttpSession httpSession) {
        UserDTO userDTO = (UserDTO) httpSession.getAttribute(USER_SESSION_ATTRIBUTE);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @PostMapping(value = "/reg")
    public ResponseEntity<?> registration(@RequestBody UserDTO userDTO) {
        if (userService.registration(userDTO) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("You have been registered!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This username is already taken");
        }
    }
}
