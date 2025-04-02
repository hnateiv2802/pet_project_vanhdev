package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class LessonRes {
    private String lessonName;
    private String chapterName;
    private String courseName;
    private String description;
    private String type;
    private String url;
    private int lessonOrder;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String sort;
    private int page;
    private int size;
}
