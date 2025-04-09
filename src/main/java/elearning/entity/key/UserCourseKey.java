package elearning.entity.key;

import java.io.Serializable;
import java.util.Objects;

public class UserCourseKey implements Serializable {
    private int userId;

    private int courseId;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCourseKey that)) return false;
        return userId == that.userId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}
