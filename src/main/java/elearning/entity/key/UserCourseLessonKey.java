package elearning.entity.key;

import java.io.Serializable;
import java.util.Objects;

public class UserCourseLessonKey implements Serializable {
    private int ucUserId;

    private int ucCourseId;

    private int lessonId;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCourseLessonKey that)) return false;
        return ucUserId == that.ucUserId && ucCourseId == that.ucCourseId && lessonId == that.lessonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucUserId, ucCourseId, lessonId);
    }
}
