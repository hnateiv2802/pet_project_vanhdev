package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ChapterRes {
    private String chapterName;
    private String courseName;
    private String description;
    private int chapterOrder;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String sort;
    private int page;
    private int size;
}
