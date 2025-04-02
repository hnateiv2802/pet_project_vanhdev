package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class LessonCreateReq {
    @NotNull(message = "Lesson Name cannot be null")
    @Size(min = 1, max = 20, message = "Lesson Name must be between 1 and 20 characters long")
    private String lessonName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @NotNull(message = "Type cannot be null")
    @Pattern(regexp = RegexConst.TYPE, message = "Type must be either 'video' or 'docx' or 'pdf' or 'slide'")
    private String type;

    @Pattern(regexp = RegexConst.URL, message = "Status must be either 'active' or 'inactive'")
    private String url;

    @NotNull(message = "Lesson Order cannot be null")
    @Positive(message = "Lesson Order must be greater than zero")
    private int lessonOrder;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @Positive(message = "ChapterID must be greater than zero")
    private int chapterID;
}
