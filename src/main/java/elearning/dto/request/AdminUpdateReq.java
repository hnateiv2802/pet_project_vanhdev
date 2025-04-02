package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminUpdateReq {
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters long")
    @Pattern(regexp = RegexConst.USERNAME, message = "Username must not contain special characters")
    private String username;

    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters long")
    @Pattern(regexp = RegexConst.PASSWORD, message = "Password must not contain spaces")
    private String password;

    @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters long")
    @Pattern(regexp = RegexConst.USERNAME, message = "Username must not contain special characters")
    private String name;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String updatedDate;
}
