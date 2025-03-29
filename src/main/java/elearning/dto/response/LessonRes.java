package elearning.dto.response;

import lombok.Data;

@Data
public class LessonRes {
    private String lessonName;
    private String chapterName;
    private String courseName;
    private String description;
    private String type;
    private String url;
    private String order;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
