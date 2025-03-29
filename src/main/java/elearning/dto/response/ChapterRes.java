package elearning.dto.response;

import lombok.Data;

@Data
public class ChapterRes {
    private String chapterName;
    private String courseName;
    private String description;
    private String order;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
