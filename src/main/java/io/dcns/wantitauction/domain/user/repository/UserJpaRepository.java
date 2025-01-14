package io.dcns.wantitauction.domain.user.repository;

import io.dcns.wantitauction.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByNickname(String nickname);

    Optional<User> findByKakaoId(Long kakaoId);
}
