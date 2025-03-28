package elearning.dto.request;

import lombok.Data;

@Data
public class AccountLoginReq {
    // @NotNull(message = "Username cannot be null")
    private String username;
    private String password;
}
