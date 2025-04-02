package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserCourseLessonReadReq {
    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String updatedDate;

    @Positive(message = "ucUserID must be greater than zero")
    private int ucUserID;

    @Positive(message = "ucCourseID must be greater than zero")
    private int ucCourseID;

    @Positive(message = "LessonID must be greater than zero")
    private int lessonID;
}
