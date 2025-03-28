package elearning.dto.response;

import lombok.Data;

@Data
public class AccountCourseRes {
    private String rating;
    private String review;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
