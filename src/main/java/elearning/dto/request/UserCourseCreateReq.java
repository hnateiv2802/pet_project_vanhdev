package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class UserCourseCreateReq {
    @NotNull(message = "Rating cannot be null")
    @PositiveOrZero(message = "Rating must be greater than zero")
    private double rating;

    @NotNull(message = "Review cannot be null")
    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String review;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @Positive(message = "UserId must be greater than zero")
    private int userId;

    @Positive(message = "CourseId must be greater than zero")
    private int courseId;
}
