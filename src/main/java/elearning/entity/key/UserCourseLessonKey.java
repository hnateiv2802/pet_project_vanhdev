package elearning.entity.key;

import java.io.Serializable;
import java.util.Objects;

public class UserCourseLessonKey implements Serializable {
    private int ucUserID;

    private int ucCourseID;

    private int lessonID;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCourseLessonKey that)) return false;
        return ucUserID == that.ucUserID && ucCourseID == that.ucCourseID && lessonID == that.lessonID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucUserID, ucCourseID, lessonID);
    }
}
