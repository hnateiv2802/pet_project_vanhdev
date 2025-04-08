package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class CourseCreateReq {
    @NotNull(message = "Course Name cannot be null")
    @Size(min = 1, max = 20, message = "Course Name must be between 1 and 20 characters long")
    private String name;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @Positive(message = "courseId must be greater than zero")
    private int courseId;
}
