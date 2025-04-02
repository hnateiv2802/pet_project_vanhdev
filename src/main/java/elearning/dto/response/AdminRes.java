package elearning.dto.response;

import lombok.Data;

@Data
public class AdminRes {
    private String username;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
