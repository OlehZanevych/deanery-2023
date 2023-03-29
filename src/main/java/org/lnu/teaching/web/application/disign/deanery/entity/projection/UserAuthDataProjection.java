package org.lnu.teaching.web.application.disign.deanery.entity.projection;

public interface UserAuthDataProjection {
    String getUsername();
    boolean getIsAdmin();
    String getPasswordHash();
}
