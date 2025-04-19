package elearning.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import elearning.constant.RegexConst;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherUpdateReq {
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

    @FutureOrPresent
    private Date createdDate;

    @FutureOrPresent
    private Date updatedDate;
}
