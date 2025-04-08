package elearning.repository;

import elearning.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
//    UserEntity findByUsername(String username);
Optional <UserEntity> findByUsername(String username);
}
