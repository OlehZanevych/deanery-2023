package org.lnu.teaching.web.application.disign.deanery.service.auth;

import org.lnu.teaching.web.application.disign.deanery.annotation.Auth;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserCredentials;

public interface AuthService {
    void login(UserCredentials userCredentials);
    void verifyAuthority(Auth auth);
}
