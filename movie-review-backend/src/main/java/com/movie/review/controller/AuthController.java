package com.movie.review.controller;

import com.movie.review.entity.UserEntity;
import com.movie.review.model.LoginRequest;
import com.movie.review.model.LoginResponse;
import com.movie.review.security.UserPrincipal;
import com.movie.review.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    @GetMapping("/login/info")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "This can only be seen by a logged in user. Your Email is: "
                + principal.getEmail() + " and your ID is: " + principal.getUserId();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this, you are an admin. Your ID: " + principal.getUserId();
        // the WebSecurityConfig class has '/admin' this URL for users with ADMIN roles only
    }
}
