package elearning.repository;

import elearning.entity.UserCourseLessonEntity;
import elearning.entity.key.UserCourseLessonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserCourseLessonRepository")
public interface UserCourseLessonRepository extends JpaRepository<UserCourseLessonEntity, UserCourseLessonKey> {}
