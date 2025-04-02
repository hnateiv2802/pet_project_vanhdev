package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserCourseRes {
    private double rating;
    private String review;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String sort;
    private int page;
    private int size;
}
