package elearning.repository;

import elearning.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lessonRepository")
public interface LessonRepository extends JpaRepository<LessonEntity, Integer> {
}
