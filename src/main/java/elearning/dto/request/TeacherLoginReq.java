package elearning.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import elearning.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherLoginReq {
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters long")
    @Pattern(regexp = RegexConst.USERNAME, message = "Username must not contain special characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters long")
    @Pattern(regexp = RegexConst.PASSWORD, message = "Password must not contain spaces")
    private String password;
}
