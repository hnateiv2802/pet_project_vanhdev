package elearning.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserRes {
    private String username;
    private String password;
    private String name;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private int age;
    private String sort;
    private int page;
    private int size;
}
