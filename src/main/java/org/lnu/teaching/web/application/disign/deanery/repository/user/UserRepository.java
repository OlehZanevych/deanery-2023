package org.lnu.teaching.web.application.disign.deanery.repository.user;

import org.lnu.teaching.web.application.disign.deanery.entity.projection.UserAuthDataProjection;
import org.lnu.teaching.web.application.disign.deanery.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserAuthDataProjection findUserAuthDataByUsername(String username);
}
