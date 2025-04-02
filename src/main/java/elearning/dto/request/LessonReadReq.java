package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class LessonReadReq {
    @Size(min = 1, max = 20, message = "Lesson Name must be between 1 and 20 characters long")
    private String lessonName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @Pattern(regexp = RegexConst.TYPE, message = "Status must be either 'active' or 'inactive'")
    private String type;

    @Pattern(regexp = RegexConst.URL, message = "Status must be either 'active' or 'inactive'")
    private String url;

    @Positive(message = "Lesson Order must be greater than zero")
    private int lessonOrder;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @FutureOrPresent
    private Date updatedDate;

    @Positive(message = "ChapterID must be greater than zero")
    private int chapterID;
}
