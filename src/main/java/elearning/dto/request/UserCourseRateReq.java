package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class UserCourseRateReq {
    @NotNull(message = "Rating cannot be null")
    @PositiveOrZero(message = "Rating must be greater than zero")
    private double rating;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String updatedDate;

    @Positive(message = "UserID must be greater than zero")
    private int userID;

    @Positive(message = "CourseID must be greater than zero")
    private int courseID;
}
