package elearning.repository;

import elearning.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CourseRepository")
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
