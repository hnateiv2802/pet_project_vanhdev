package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChapterCreateReq {
    @NotNull(message = "Chapter Name cannot be null")
    @Size(min = 1, max = 20, message = "Chapter Name must be between 1 and 20 characters long")
    private String chapterName;

    @NotNull(message = "Course Name cannot be null")
    @Size(min = 1, max = 20, message = "Course Name must be between 1 and 20 characters long")
    private String courseName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @NotNull(message = "Order cannot be null")
    @Positive(message = "Order must be greater than zero")
    private int order;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;
}
