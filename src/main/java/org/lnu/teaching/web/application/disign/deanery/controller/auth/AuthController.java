package org.lnu.teaching.web.application.disign.deanery.controller.auth;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.annotation.Auth;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserCredentials;
import org.lnu.teaching.web.application.disign.deanery.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void login(@RequestBody @Valid UserCredentials userCredentials) {
        authService.login(userCredentials);
    }

    @Auth
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("refresh-token")
    public void refreshToken() {
    }
}
