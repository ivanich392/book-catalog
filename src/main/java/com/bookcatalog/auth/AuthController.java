package com.bookcatalog.auth;

import com.bookcatalog.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthController.class);

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username
    ) {

        logger.info("User logged in: {}", username);

        UserDetails userDetails;

        if (username.equals("admin")) {

            userDetails = new User(
                    username,
                    "",
                    List.of(
                            new SimpleGrantedAuthority("ROLE_ADMIN")
                    )
            );

        } else {

            userDetails = new User(
                    username,
                    "",
                    List.of(
                            new SimpleGrantedAuthority("ROLE_USER")
                    )
            );
        }

        String token = jwtService.generateToken(userDetails);

        return Map.of(
                "token", token
        );
    }
}