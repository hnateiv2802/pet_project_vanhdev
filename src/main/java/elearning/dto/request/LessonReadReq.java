package elearning.dto.request;

import lombok.Data;

@Data
public class LessonReadReq {
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
}
