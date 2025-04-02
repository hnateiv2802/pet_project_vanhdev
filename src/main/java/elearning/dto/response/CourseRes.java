package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class CourseRes {
    private String courseName;
    private String teacherName;
    private String description;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String sort;
    private int page;
    private int size;
}
