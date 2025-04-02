package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class ChapterUpdateReq {
    @Size(min = 1, max = 20, message = "Chapter Name must be between 1 and 20 characters long")
    private String chapterName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @Positive(message = "Chapter Order must be greater than zero")
    private int chapterOrder;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @FutureOrPresent
    private Date updatedDate;

    @Positive(message = "CourseID must be greater than zero")
    private int courseID;
}
