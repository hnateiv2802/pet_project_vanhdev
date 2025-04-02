package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class ChapterCreateReq {
    @NotNull(message = "Chapter Name cannot be null")
    @Size(min = 1, max = 20, message = "Chapter Name must be between 1 and 20 characters long")
    private String chapterName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @NotNull(message = "Chapter Order cannot be null")
    @Positive(message = "Chapter Order must be greater than zero")
    private int chapterOrder;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @Positive(message = "CourseID must be greater than zero")
    private int courseID;
}
