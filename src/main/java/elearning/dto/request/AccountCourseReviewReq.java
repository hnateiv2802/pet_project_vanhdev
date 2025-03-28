package elearning.dto.request;

import lombok.Data;

@Data
public class AccountCourseReviewReq {
    private String rating;
    private String review;
    private String status;
    private String createdDate;
    private String updatedDate;
}
