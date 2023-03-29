package org.lnu.teaching.web.application.disign.deanery.config.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.lnu.teaching.web.application.disign.deanery.annotation.Auth;
import org.lnu.teaching.web.application.disign.deanery.service.auth.AuthService;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@AllArgsConstructor
public class AuthAspect {

    private final AuthService authService;

    @Before("@annotation(auth) && within(@org.springframework.web.bind.annotation.RestController *)")
    public void verifyAuthoritySpecifiedForMethod(Auth auth) {
        authService.verifyAuthority(auth);
    }

    public void verifyAuthoritySpecifiedForControllerClass() {

    }
}
