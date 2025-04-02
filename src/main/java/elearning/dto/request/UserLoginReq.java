package elearning.dto.request;

import elearning.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginReq {
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters long")
    @Pattern(regexp = RegexConst.USERNAME, message = "Username must not contain special characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters long")
    @Pattern(regexp = RegexConst.PASSWORD, message = "Password must not contain spaces")
    private String password;
}
