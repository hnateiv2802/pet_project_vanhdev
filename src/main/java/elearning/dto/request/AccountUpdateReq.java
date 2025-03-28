package elearning.dto.request;

import lombok.Data;

@Data
public class AccountUpdateReq {
    private String username;
    private String password;
    private String name;
    private String status;
    private String createdDate;
    private String updatedDate;
}
