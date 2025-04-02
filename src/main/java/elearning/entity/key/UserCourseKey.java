package elearning.entity.key;

import java.io.Serializable;
import java.util.Objects;

public class UserCourseKey implements Serializable {
    private int userID;

    private int courseID;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCourseKey that)) return false;
        return userID == that.userID && courseID == that.courseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, courseID);
    }
}
