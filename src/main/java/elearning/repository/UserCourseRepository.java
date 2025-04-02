package elearning.repository;

import elearning.entity.UserCourseEntity;
import elearning.entity.key.UserCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserCourseRepository")
public interface UserCourseRepository extends JpaRepository<UserCourseEntity, UserCourseKey> {
}
