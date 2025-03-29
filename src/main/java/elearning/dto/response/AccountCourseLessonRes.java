package elearning.dto.response;

import lombok.Data;

@Data
public class AccountCourseLessonRes {
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
