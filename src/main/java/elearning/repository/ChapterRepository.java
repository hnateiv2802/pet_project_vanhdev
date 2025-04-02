package elearning.repository;

import elearning.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ChapterRepository")
public interface ChapterRepository extends JpaRepository<ChapterEntity, Integer> {
}
