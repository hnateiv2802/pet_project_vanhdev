package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class UserCourseUpdateReq {
    @PositiveOrZero(message = "Rating must be greater than zero")
    private double rating;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String review;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @FutureOrPresent
    private Date updatedDate;

    @Positive(message = "UserID must be greater than zero")
    private int userID;

    @Positive(message = "CourseID must be greater than zero")
    private int courseID;
}
