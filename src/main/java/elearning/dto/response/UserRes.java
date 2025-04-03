package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserRes {
    private String username;
    private String nickname;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String sort;
    private int page;
    private int size;
}
