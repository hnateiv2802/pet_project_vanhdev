package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class UserCourseLessonCreateReq {
    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @Positive(message = "ucUserID must be greater than zero")
    private int ucUserID;

    @Positive(message = "ucCourseID must be greater than zero")
    private int ucCourseID;

    @Positive(message = "LessonID must be greater than zero")
    private int lessonID;
}
