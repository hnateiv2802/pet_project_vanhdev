package elearning.repository;

import elearning.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("teacherRepos")
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
    Optional<TeacherEntity> findByUsername(String username);
}
