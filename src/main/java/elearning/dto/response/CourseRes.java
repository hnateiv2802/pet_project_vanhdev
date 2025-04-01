package elearning.dto.response;

import lombok.Data;

@Data
public class CourseRes {
    private String courseName;
    private String teacherName;
    private String description;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
