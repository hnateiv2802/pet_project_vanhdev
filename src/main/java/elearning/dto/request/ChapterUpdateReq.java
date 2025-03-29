package elearning.dto.request;

import lombok.Data;

@Data
public class ChapterUpdateReq {
    private String chapterName;
    private String courseName;
    private String description;
    private String order;
    private String status;
    private String createdDate;
    private String updatedDate;
}
