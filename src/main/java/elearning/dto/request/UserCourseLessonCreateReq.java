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

    @Positive(message = "ucUserId must be greater than zero")
    private int ucUserId;

    @Positive(message = "ucCourseId must be greater than zero")
    private int ucCourseId;

    @Positive(message = "LessonId must be greater than zero")
    private int lessonId;
}
